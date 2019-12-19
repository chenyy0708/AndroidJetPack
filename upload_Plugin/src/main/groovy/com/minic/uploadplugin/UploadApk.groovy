import org.gradle.api.Plugin
import org.gradle.api.Project

class UploadApk implements Plugin<Project> {

    @Override
    void apply(Project project) {

        def extension = project.extensions.create('uploadApkInfo', UploadApkPluginExtension)
        project.task("assembleWithFirim").doLast {
            print("appName:" + extension.appName)
            print("appIconPath:" + extension.appIconPath)
        }
    }
}
