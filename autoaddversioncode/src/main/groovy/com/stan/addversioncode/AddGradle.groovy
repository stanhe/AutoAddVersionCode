package com.stan.addversioncode

import org.gradle.api.DefaultTask
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction
import java.util.regex.Pattern


public class AddGradle extends DefaultTask{
    @TaskAction
    addGradleFile () {
        println("------> start addGradle <------")
        println("---->file : ${getPath()}")
        println("project path : ${project.path}")
        println("project getPath : ${project.getPath()}/build.gradle")
        try {
            def buildFile = project.file("build.gradle")
            def buildText = buildFile.getText()
            println("project buildText : ${buildText}")
            def matcher = Pattern.compile("versionCode (\\d+)").matcher(buildText)
            matcher.find()
            def versionCode = Integer.parseInt(matcher.group(1))
            def newBuildText = matcher.replaceAll("versionCode " + ++versionCode)
            buildFile.write(newBuildText)
        }catch (Exception e){
            e.printStackTrace()
            println("<----- exception ----->")
        }
    }
}