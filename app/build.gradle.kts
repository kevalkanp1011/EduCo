plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("kotlinx-serialization")
    id("kotlin-parcelize")
    //id("com.google.dagger.hilt.android")
    id("com.google.gms.google-services")
    //id("com.google.firebase.crashlytics")
    //id("com.google.devtools.ksp")
}

android {
    namespace = "dev.kevalkanpariya.educo"
    compileSdk = 34

    defaultConfig {
        applicationId = "dev.kevalkanpariya.educo"
        minSdk = 26
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

    //Core
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.core:core-splashscreen:1.0.1")


    implementation("androidx.activity:activity-compose:1.8.2")
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")

    // Navigation Compose
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    // Paging 3.0
    implementation("androidx.paging:paging-compose:3.2.1")

    // DataStore Preferences
    implementation("androidx.datastore:datastore-preferences:1.0.0")
    // Palette API
    implementation("androidx.palette:palette-ktx:1.0.0")


    //Lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")


    implementation(platform("androidx.compose:compose-bom:2024.02.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-util")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.runtime:runtime-livedata")


    //Testing
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    testImplementation("org.mockito:mockito-core:5.7.0")

    val koin_version = "3.5.0"
    val koin_compse_version = "3.5.0"


    //Koin Di
    implementation("io.insert-koin:koin-androidx-compose:$koin_compse_version")
    testImplementation("io.insert-koin:koin-test:$koin_version")
    testImplementation("io.insert-koin:koin-test-junit4:$koin_version")
    testImplementation("io.insert-koin:koin-android-test:$koin_version")

    //Compose Ui Testing
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.02.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")



    //Firebase
    implementation(platform("com.google.firebase:firebase-bom:32.7.0"))
    implementation("com.google.firebase:firebase-auth")
    //implementation("com.google.firebase:firebase-crashlytics")
    implementation("com.google.firebase:firebase-firestore")
    implementation("com.google.firebase:firebase-storage")

    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.1-Beta")


    
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
    //implementation("com.google.dagger:hilt-android:2.44")
    //kapt("com.google.dagger:hilt-android-compiler:2.44")





    // Sign in With Google
    implementation("com.google.android.gms:play-services-auth:21.1.0")
    implementation("androidx.credentials:credentials:1.3.0-alpha03")

    // optional - needed for credentials support from play services, for devices running
    // Android 13 and below.
    implementation("androidx.credentials:credentials-play-services-auth:1.3.0-alpha03")
    implementation("com.google.android.libraries.identity.googleid:googleid:1.1.0")

    // FOR LOGGING
    implementation("com.jakewharton.timber:timber:5.0.1")

    // Exoplayer
    implementation("androidx.media3:media3-exoplayer:1.3.1")
    implementation("androidx.media3:media3-ui:1.3.1")




}

kapt {
    correctErrorTypes = true
}