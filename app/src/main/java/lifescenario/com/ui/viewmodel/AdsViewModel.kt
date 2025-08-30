package lifescenario.com.ui.viewmodel

import android.app.Activity
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yandex.mobile.ads.common.AdError
import com.yandex.mobile.ads.common.AdRequestConfiguration
import com.yandex.mobile.ads.common.AdRequestError
import com.yandex.mobile.ads.common.ImpressionData
import com.yandex.mobile.ads.rewarded.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AdsViewModel(
    private val gameViewModel: GameViewModel
) : ViewModel(), RewardedAdLoadListener, RewardedAdEventListener {

    companion object {
        const val YANDEX_REWARDED_UNIT = "R-M-17029464-1"
    }

    private var rewardedAdLoader: RewardedAdLoader? = null
    private var rewardedAd: RewardedAd? = null

    private val _isAdAvailable = MutableStateFlow(false)
    val isAdAvailable: StateFlow<Boolean> = _isAdAvailable

    private val _rewardEarned = MutableStateFlow(false)
    val rewardEarned: StateFlow<Boolean> = _rewardEarned

    fun init(activity: Activity) {
        rewardedAdLoader = RewardedAdLoader(activity).apply {
            setAdLoadListener(this@AdsViewModel)
        }
    }

    fun loadAd() {
        _isAdAvailable.value = false
        val config = AdRequestConfiguration.Builder(YANDEX_REWARDED_UNIT).build()
        rewardedAdLoader?.loadAd(config)
    }

    fun showAd(activity: Activity) {
        rewardedAd?.setAdEventListener(this)
        rewardedAd?.show(activity)
    }

    fun clearReward() { _rewardEarned.value = false }

    override fun onAdLoaded(ad: RewardedAd) {
        rewardedAd = ad
        _isAdAvailable.value = true
    }

    override fun onAdFailedToLoad(error: AdRequestError) { _isAdAvailable.value = false }

    override fun onAdShown() {}
    override fun onAdFailedToShow(adError: AdError) { _isAdAvailable.value = false }
    override fun onAdDismissed() { rewardedAd = null; loadAd() }
    override fun onAdClicked() {}
    override fun onAdImpression(data: ImpressionData?) {}
    override fun onCleared() {
        rewardedAdLoader?.setAdLoadListener(null)
        rewardedAdLoader = null
        rewardedAd?.setAdEventListener(null)
        rewardedAd = null
        super.onCleared()
    }

    override fun onRewarded(reward: Reward) {
        _rewardEarned.value = true
        viewModelScope.launch {
            val pendingStats = gameViewModel.showInsufficientStatOverlay.value
            gameViewModel.applyRewardStatsFromAd(pendingStats)
        }
    }
}

