package com.stan.addversioncode

import org.gradle.api.Plugin
import org.gradle.api.Project

public class AddVersionCode implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.extensions.create("versionFile", VersionFile);
        project.task("startAddGradle", type: AddGradle)
        project.task("startAddManifest", type: AddManifest)
        project.tasks.whenTaskAdded { task ->
            if (task.name.contains('ReleaseBuildConfig')) {
                if (project.versionFile==null || project.versionFile.desFile==null || project.versionFile.desFile == "gradle") {
                    task.dependsOn 'startAddGradle'//需要依赖实例
                } else if (project.versionFile.desFile == "manifest") {
                    task.dependsOn 'startAddManifest'
                } else if (project.versionFile.desFile == "all") {
                    task.dependsOn 'startAddGradle','startAddManifest'
                }
            }
        }
    }
}
