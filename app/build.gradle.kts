plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id ("kotlin-kapt")
    id ("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.assesment"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.assesment"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    dataBinding{
        enable = true
    }
}

dependencies {

    implementation(project(":Listing:presentation"))
    implementation(project(":Listing:domain"))
    implementation(project(":Listing:data"))
    implementation(project(":Details:presentation"))
    implementation(project(":common:utils"))

    implementation (Dependencies.core)
    implementation(Dependencies.appCompat)
    implementation(Dependencies.androidMaterial)
    implementation(Dependencies.constraintLayout)
    testImplementation(TestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.junit)
    androidTestImplementation(AndroidTestImplementation.espresso)

    implementation (DaggerHilt.hilt)
    kapt (DaggerHilt.hiltAndroidCompiler)
    kapt (DaggerHilt.hiltCompiler)

    implementation(Room.room)
    kapt(Room.roomCompiler)

    implementation("com.google.code.gson:gson:2.10.1")

}