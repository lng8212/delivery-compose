import com.longkd2.convention.implementation
import com.longkd2.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * @Author: longkd
 * @Since: 09:59 - 30/11/24
 */
class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("starter.android.library")
                apply("starter.android.library.compose")
                apply("starter.android.hilt")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            dependencies {
                implementation(project(":core:utils"))
                implementation(project(":domain"))
                implementation(libs.findLibrary("kotlinx-serialization-json").get())
            }
        }
    }
}
