plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.kezong.fat-aar")
    id("de.mannodermaus.android-junit5")
}

android {
    namespace = "com.awilab.common"
    compileSdk = 33

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api("androidx.core:core-ktx:1.9.0")
    api("androidx.appcompat:appcompat:1.6.1")

    //region Koin
    api("io.insert-koin:koin-core:3.3.3")
    api("io.insert-koin:koin-android:3.3.3")
    api("io.insert-koin:koin-androidx-workmanager:3.3.3")
    //endregion

    //region Coroutines
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
    //endregion

    //region Utils
    api("com.jakewharton.threetenabp:threetenabp:1.4.4")
    api("com.blankj:utilcodex:1.31.1")
    //endregion

    implementation(project(":BaseModules:testing"))
}