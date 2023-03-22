plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.awilab.testing"
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
    testApi("junit:junit:4.13.2")
    androidTestApi("androidx.test.ext:junit:1.1.5")
    androidTestApi("androidx.test.espresso:espresso-core:3.5.1")

    //region Koin
    testApi("io.insert-koin:koin-test:3.3.3")
    //endregion

    // (Required) Writing and executing Unit Tests on the JUnit Platform
    testApi("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testApi("org.junit.jupiter:junit-jupiter-engine:5.8.2")

    // (Optional) If you need "Parameterized Tests"
    testApi("org.junit.jupiter:junit-jupiter-params:5.8.2")

    // (Optional) If you also have JUnit 4-based tests
    testApi("junit:junit:4.13.2")
    testApi("org.junit.vintage:junit-vintage-engine:5.8.2")

    api("com.google.truth:truth:1.1.3")
}