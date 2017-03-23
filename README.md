[![](https://jitpack.io/v/stanhe/AutoAddVersionCode.svg)](https://jitpack.io/#stanhe/AutoAddVersionCode)

#### This a gradle plugin for auto add versionCode when release.

### How to use
The first way to use it with jitpack.
```
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
when you use the default settings,this plugin will add versionCode in build.grale only when release.so there are some optional filds to benefit your.
* 'gradle' or (default no) --- this will only add versionCode in build.gradle when release.
* 'manifest'  --- this will only add versionCode in manifest.xml when release.
* 'all' --- add versionCode in buid.gradle and manifest.xml when release.

```
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


### release log
#### v 1.0.3 
refactor Judgment logic .
fix release can't handle versionCode with productFlavors.
