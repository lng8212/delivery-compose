plugins {
    alias(libs.plugins.starter.android.application)
    alias(libs.plugins.starter.android.application.compose)
    alias(libs.plugins.starter.android.hilt)
}

android {
    namespace = "com.longkd.delivery"

    defaultConfig {
        applicationId = "com.longkd.delivery"
    }
}

dependencies {
    implementation(project(":presentation"))
    implementation(project(":core:utils"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.androidx.datastore.preferences)
}