package com.stan.addversioncode

import java.util.regex.Pattern
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

public class AddManifest extends DefaultTask {
    @TaskAction
    next(){
        try {
            def manifestFile = project.file("src/main/AndroidManifest.xml")
            def pattern = Pattern.compile("versionCode=\"(\\d+)\"")
            def manifestText = manifestFile.getText()
            def matcher = pattern.matcher(manifestText)
            if (matcher.find()) {
                def versionCode = Integer.parseInt(matcher.group(1))
                def manifestContent = matcher.replaceAll("versionCode=\"" + ++versionCode + "\"")
                manifestFile.write(manifestContent)
            }else {
                println('Not found versionCode defined in manifest.')
            }
        }catch (Exception e){
            e.printStackTrace()
        }
    }
}
