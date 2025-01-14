import com.steleot.jetpackcompose.playground.plugins.AddBenchmarkBuildTypePlugin
import com.steleot.jetpackcompose.playground.plugins.BaseAndroidConfigurationPlugin

plugins {
    id(BuildPlugins.androidLibrary)
    kotlin(BuildPlugins.kotlinAndroid)
}

apply<AddBenchmarkBuildTypePlugin>()
apply<BaseAndroidConfigurationPlugin>()

android {
    compileSdk = AndroidConfiguration.compileSdk

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

dependencies {
    implementation(androidx.coreKtx)
}