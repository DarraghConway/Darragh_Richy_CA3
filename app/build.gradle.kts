plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.darragh_richy_ca3"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.darragh_richy_ca3"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation (libs.androidx.lifecycle.viewmodel.compose) // Ensure this is included
    implementation (libs.androidx.lifecycle.runtime.ktx.v260)
    implementation(libs.androidx.animation.v151)
    implementation(libs.coil.compose)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.ui)
    implementation(libs.material3)


    // Retrofit for network requests
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // Add lifecycle-viewmodel-compose for ViewModel support in Jetpack Compose
    implementation(libs.androidx.lifecycle.viewmodel.compose.v262)

    // Jetpack Compose Animation and Preview
    implementation(libs.androidx.animation)
    implementation(libs.ui.tooling.preview)

    // Activity Compose v1.3.1 (Double-check, might conflict with libs.androidx.activity.compose)
    implementation(libs.androidx.activity.compose.v131)

    // Lifecycle and LiveData
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.runtime.livedata)

    // Jetpack Navigation Compose
    implementation (libs.androidx.navigation.compose)

    // Testing dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Debugging dependencies
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
