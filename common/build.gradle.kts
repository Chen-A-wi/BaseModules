plugins {
	id("com.android.library")
	id("org.jetbrains.kotlin.android")
}

android {
	namespace = "com.awilab.common"
	compileSdk = 33

	defaultConfig {
		minSdk = 24
		targetSdk = 33

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
	testApi("junit:junit:4.13.2")
	androidTestApi("androidx.test.ext:junit:1.1.5")
	androidTestApi("androidx.test.espresso:espresso-core:3.5.1")

	//region Utils
	api("com.jakewharton.threetenabp:threetenabp:1.4.4")
	//endregion
}