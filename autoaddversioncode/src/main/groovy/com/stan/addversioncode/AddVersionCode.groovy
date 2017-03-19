package com.stan.addversioncode

import org.gradle.api.Plugin
import org.gradle.api.Project

public class AddVersionCode implements Plugin<Project> {
    @Override
    void apply(Project project) {
        project.extensions.create("versionFile",VersionFile);
        println("start when task added")
        project.task("startAddGradle",type:AddGradle)
        project.task("hello",dependsOn: 'startAddGradle')<<{ task ->
            if (task.name == "hello") {
                println("------Find Task: hello ------")
                println("--->Project.versionFile.desFile: ${project.versionFile.desFile}<---")
                if (project.versionFile.desFile == "gradle") {
//                    task.dependsOn 'startAddGradle'
                    println("this is gradle")
                }else if (project.versionFile.desFile == "manifest"){
//                    task.dependsOn AddManifest
                    println("this is manifest")
                }else if (project.versionFile.desFile == "all"){
//                    task.dependsOn AddGradle,AddManifest
                    println("this is all")
                }
            }
        }


    }
}
