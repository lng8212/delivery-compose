package com.longkd2.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion =
                libs.findVersion("androidxComposeCompiler").get().toString()
        }

        dependencies {
            implementation(libs.findLibrary("androidx-navigation-compose").get())
            implementation(libs.findLibrary("androidx-ui-graphics").get())
            implementation(libs.findLibrary("androidx-ui-tooling-preview").get())
            implementation(libs.findLibrary("androidx-material3").get())
            implementation(libs.findLibrary("androidx-activity-compose").get())
            implementation(platform(libs.findLibrary("androidx-compose-bom").get()))
            implementation(libs.findLibrary("androidx-lifecycle-runtime-compose-android").get())
            debugImplementation(libs.findLibrary("androidx-ui-tooling").get())
            debugImplementation(libs.findLibrary("androidx-ui-test-manifest").get())
        }
    }
}
