plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
}
buildscript {
    dependencies {
        classpath(libs.hilt.android.gradle.plugin)
    }
}