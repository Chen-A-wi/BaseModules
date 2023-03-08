plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.kezong.fat-aar")
}

android {
    namespace = "com.awilab.network"
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
    api("com.squareup.okhttp3:okhttp:5.0.0-alpha.9")
    api("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.10")

    api("com.squareup.retrofit2:retrofit:2.9.0")
    api("com.squareup.retrofit2:converter-moshi:2.9.0")

    api("com.squareup.moshi:moshi:1.14.0")
    api("com.squareup.moshi:moshi-kotlin:1.14.0")

    implementation(project(":BaseModules:common"))
}