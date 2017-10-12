[![](https://jitpack.io/v/stanhe/AutoAddVersionCode.svg)](https://jitpack.io/#stanhe/AutoAddVersionCode)
[![](https://img.shields.io/badge/plugin-gradle-orange.svg)](http://stanho.top/2017/03/19/gradle_plugin)
## This is a gradle plugin for auto add versionCode when release.

### Usage
```java
apply plugin: 'com.android.application'

//add this at top of your app's build.gradle.
apply plugin: 'addversioncode'
buildscript{
    repositories{
        maven { url 'https://jitpack.io' }
    }
    dependencies{
        classpath 'com.github.stanhe:AutoAddVersionCode:1.0.3'
    }
}

android {
    compileSdkVersion 25
    buildToolsVersion "25.0.2"
    ......
}
```
### Optional fields

when you use the default settings,this plugin will add versionCode in build.grale only when release.

there are some optional filds to benefit you.
* 'gradle'(default) --- this will only add versionCode in build.gradle when release.
* 'manifest'  --- this will only add versionCode in manifest.xml when release.
* 'all' --- add versionCode in buid.gradle and manifest.xml when release.

```java
apply plugin: 'com.android.application'

//add this at top of your app's build.gradle.
apply plugin: 'addversioncode'
buildscript{
    repositories{
        maven { url 'https://jitpack.io' }
    }
    dependencies{
        classpath 'com.github.stanhe:AutoAddVersionCode:1.0.3'
    }
}
//optional Fild
versionFile{
    desFile = 'manifest'
}

android {
    compileSdkVersion 25
    buildToolsVersion "25.0.2"
    ......
}
```


### Release log
#### v 1.0.3 
Refactor Judgment logic .
fix release can't handle versionCode with productFlavors.
