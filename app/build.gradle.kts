plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "fr.jux.idualremote"
    compileSdk = 34

    defaultConfig {
        applicationId = "fr.jux.idualremote"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.1"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
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
}