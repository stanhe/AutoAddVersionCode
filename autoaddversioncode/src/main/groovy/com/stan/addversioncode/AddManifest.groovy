package com.stan.addversioncode

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction;

/**
 * Created by stan on 2017/3/18.
 */
import java.util.regex.Pattern
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
public class AddManifest extends DefaultTask {
    @TaskAction
    addManifestFile(){
        println("start-----addMainifest----!")
        try {
            def manifestFile = project.file("src/main/AndroidManifest.xml")
            def pattern = Pattern.compile("versionCode=\"(\\d+)\"")
            def manifestText = manifestFile.getText()
            def matcher = pattern.matcher(manifestText)
            matcher.find()
            def versionCode = Integer.parseInt(matcher.group(1))
            def manifestContent = matcher.replaceAll("versionCode=\"" + ++versionCode + "\"")
            manifestFile.write(manifestContent)
        }catch (Exception e){
            e.printStackTrace()
            println("<----- exception ----->")
        }
    }
}
