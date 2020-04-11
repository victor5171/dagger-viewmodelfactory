import com.novoda.gradle.release.PublishExtension
import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("com.novoda.bintray-release")
}

kapt {
    correctErrorTypes = true
}

val currentTag = System.getenv("CIRCLE_TAG") ?: "0.0.1"

configure<PublishExtension> {
    userOrg = "victor5171"
    groupId = "org.xtras.daggerviewmodelfactory"
    repoName = "xtras"
    artifactId = "dagger-viewmodelfactory"
    publishVersion = currentTag
    bintrayUser = "victor5171"
    bintrayKey = System.getenv("BINTRAY_KEY")
    desc = "A ViewModel Factory to be used along with Dagger2!"
    website = "https://github.com/victor5171/dagger-viewmodelfactory"
}

android {
    compileSdkVersion(properties["compileSdkVersion"] as Int)
    buildToolsVersion(properties["buildToolsVersion"] as String)

    defaultConfig {
        minSdkVersion(properties["minSdkVersion"] as Int)
        targetSdkVersion(properties["targetSdkVersion"] as Int)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk7", KotlinCompilerVersion.VERSION))
    implementation("androidx.appcompat:appcompat:${properties["appCompatVersion"]}")
    implementation("androidx.core:core-ktx:${properties["coreKtxVersion"]}")
    implementation("com.google.dagger:dagger:${properties["daggerVersion"]}")

    testImplementation("junit:junit:${properties["junit4Version"]}")
    kaptTest("com.google.dagger:dagger-compiler:${properties["daggerVersion"]}")
}
