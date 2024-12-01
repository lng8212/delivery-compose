import com.longkd2.convention.implementation
import com.longkd2.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

/**
 * @Author: longkd
 * @Since: 10:03 - 30/11/24
 */
class AndroidHiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("dagger.hilt.android.plugin")
                apply("com.google.devtools.ksp")
            }

            dependencies {
                implementation(libs.findLibrary("androidx-hilt-navigation-compose").get())
                implementation(libs.findLibrary("hilt-android").get())
                "ksp"(libs.findLibrary("hilt-android-compiler").get())
            }
        }
    }
}
