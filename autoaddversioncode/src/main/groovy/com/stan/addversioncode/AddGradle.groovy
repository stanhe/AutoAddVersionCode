package com.stan.addversioncode

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import java.util.regex.Pattern


public class AddGradle extends DefaultTask{
    @TaskAction
    next(){
        try {
            def buildFile = project.file("build.gradle")
            def buildText = buildFile.getText()
            def matcher = Pattern.compile("versionCode (\\d+)").matcher(buildText)
            if (matcher.find()) {
                def versionCode = Integer.parseInt(matcher.group(1))
                def newBuildText = matcher.replaceAll("versionCode " + ++versionCode)
                buildFile.write(newBuildText)
            }else {
                println('Not found versionCode defined in gradle.')
            }
        }catch (Exception e){
            e.printStackTrace()
        }
    }
}