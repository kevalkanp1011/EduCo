plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlinx-serialization")
    id("kotlin-parcelize")
    id("com.google.dagger.hilt.android")
    //id("com.google.devtools.ksp")
}

android {
    namespace = "dev.kevalkanpariya.educo"
    compileSdk = 34

    defaultConfig {
        applicationId = "dev.kevalkanpariya.educo"
        minSdk = 22
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    val accompanist_version = "0.24.3-alpha"

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    // Splash API
    implementation("androidx.core:core-splashscreen:1.0.1")
    // Navigation Compose
    implementation("androidx.navigation:navigation-compose:2.7.7")
    // Paging 3.0
    implementation("androidx.paging:paging-compose:3.2.1")
    // DataStore Preferences
    implementation("androidx.datastore:datastore-preferences:1.0.0")
    // Palette API
    implementation("androidx.palette:palette-ktx:1.0.0")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")


    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")


    implementation(platform("androidx.compose:compose-bom:2024.02.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-util")
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.runtime:runtime-livedata")


    //Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //Compose Ui Testing
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.02.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")





    
    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")





    // Coil
    implementation("io.coil-kt:coil-compose:2.4.0")


    // Swipe to Refresh - Accompanist
    implementation("com.google.accompanist:accompanist-swiperefresh:$accompanist_version")

    // System UI Controller - Accompanist
    implementation("com.google.accompanist:accompanist-systemuicontroller:$accompanist_version")

    implementation("com.google.accompanist:accompanist-flowlayout:$accompanist_version")



    // Dagger - Hilt
    implementation("com.google.dagger:hilt-android:2.44")
    kapt("com.google.dagger:hilt-android-compiler:2.44")





    // Sign in With Google
    implementation("com.google.android.gms:play-services-auth:20.7.0")

    // FOR LOGGING
    implementation("com.jakewharton.timber:timber:5.0.1")




}

kapt {
    correctErrorTypes = true
}