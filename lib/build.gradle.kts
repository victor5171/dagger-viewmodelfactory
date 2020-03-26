import org.jetbrains.kotlin.config.KotlinCompilerVersion
import com.novoda.gradle.release.PublishExtension

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
    id("com.novoda.bintray-release")
}

configure<PublishExtension> {
    userOrg = "victor5171"
    groupId = "org.xtras.daggerviewmodelfactory"
    repoName = "dagger-viewmodelfactory"
    artifactId = "dagger-viewmodelfactory"
    publishVersion = "0.0.1"
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

    androidTestImplementation("androidx.test.ext:junit:${properties["junitExtVersion"]}")
    androidTestImplementation("androidx.test.espresso:espresso-core:${properties["espressoVersion"]}")
}
