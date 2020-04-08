import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(properties["compileSdkVersion"] as Int)
    buildToolsVersion(properties["buildToolsVersion"] as String)

    defaultConfig {
        applicationId = "org.xtras.recyclerxtras.app"
        minSdkVersion(properties["minSdkVersion"] as Int)
        targetSdkVersion(properties["targetSdkVersion"] as Int)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk7", KotlinCompilerVersion.VERSION))
    implementation("androidx.appcompat:appcompat:${properties["appCompatVersion"]}")
    implementation("androidx.core:core-ktx:${properties["coreKtxVersion"]}")
    implementation("com.google.dagger:dagger:${properties["daggerVersion"]}")
    implementation(project(":lib"))
    kapt("com.google.dagger:dagger-compiler:${properties["daggerVersion"]}")

    testImplementation("junit:junit:${properties["junit4Version"]}")
}
