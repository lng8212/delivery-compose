plugins {
    `kotlin-dsl`
}

group = "com.longkd.build_logic.convention"

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "starter.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "starter.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "starter.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "starter.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidDomain") {
            id = "starter.android.domain"
            implementationClass = "AndroidDomainConventionPlugin"
        }
        register("androidFeature") {
            id = "starter.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("androidHilt") {
            id = "starter.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
    }
}
