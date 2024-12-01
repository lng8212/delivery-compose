plugins {
    alias(libs.plugins.starter.android.library)
    alias(libs.plugins.starter.android.library.compose)
}

android {
    namespace = "com.longkd.utils"
}

dependencies {
    implementation(libs.androidx.datastore.preferences)
}