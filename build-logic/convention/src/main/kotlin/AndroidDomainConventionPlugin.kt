import com.longkd2.convention.implementation
import com.longkd2.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

/**
 * @Author: longkd
 * @Since: 22:43 - 1/12/24
 */
class AndroidDomainConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("starter.android.library")
                apply("starter.android.hilt")
                apply("kotlin-parcelize")
            }

            dependencies {
                implementation(project(":data"))
                implementation(libs.findLibrary("kotlinx-serialization-json").get())
            }
        }
    }

}