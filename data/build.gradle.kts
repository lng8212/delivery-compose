plugins {
    alias(libs.plugins.starter.android.library)
    alias(libs.plugins.starter.android.hilt)
}

android {
    namespace = "com.longkd.data"
}

dependencies {
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
}