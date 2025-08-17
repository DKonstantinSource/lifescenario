plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kapt)
    alias(libs.plugins.compose.compiler)
    id("org.jetbrains.kotlin.plugin.serialization") version "2.1.21"
}


android {
    namespace = "lifescenario.com"
    compileSdk = 35

    defaultConfig {
        applicationId = "lifescenario.com"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.6"
    }
}

dependencies {

    //Yandex ADS
//    implementation("com.yandex.android:mobileads-mediation:7.14.1.0")
    implementation ("com.yandex.android:mobileads:7.14.1")


    //VK
    implementation ("com.vk:android-sdk-core:4.1.0")
    implementation ("com.vk:android-sdk-api:4.1.0")

    //VK ADS


    //okhttp3
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")


    //COIL
    implementation ("io.coil-kt:coil-compose:2.6.0")

    //Glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")

    //Icon extended
    implementation ("androidx.compose.material:material-icons-extended:1.6.0")


    //Permission
    implementation ("com.google.accompanist:accompanist-permissions:0.30.1")

    //Horizontal Cards
    implementation ("com.google.accompanist:accompanist-pager:0.30.1")
    implementation ("com.google.accompanist:accompanist-pager-indicators:0.30.1")

    //Horizontal Pages
    implementation ("com.google.accompanist:accompanist-pager:0.34.0")


//Compose
    implementation(libs.compose.lifecycle)
    implementation(libs.compose)
    implementation(libs.activity.compose)
    implementation(libs.coil.compose)
    implementation(libs.accompanist.pager)
    implementation(libs.accompanist.pager.indicators)
    implementation(libs.compose.navigation)
    debugImplementation(libs.compose.ui.tooling)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.compose.material3)
    implementation(libs.lifecycle.viewmodel.ktx)

    //Retrofit
    implementation(libs.retrofit)
    implementation(libs.converterGson)
    implementation(libs.gson)
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.1")

    //Room
    implementation(libs.bundles.room)
    kapt(libs.room.compiler)

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")

    //Coroutines
    implementation(libs.coroutines.android)

    //Dagger
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    //Koin
    implementation("io.insert-koin:koin-androidx-compose:3.5.3")
    implementation("io.insert-koin:koin-android:3.5.3")

    //EncryptedPref
    implementation("androidx.security:security-crypto:1.1.0-alpha06")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

