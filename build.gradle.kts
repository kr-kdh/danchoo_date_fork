buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
//        classpath("com.android.tools.build:gradle:7.2.2")
//        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
        classpath("com.google.gms:google-services:4.3.13")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Hilt.version}")
        classpath("de.mannodermaus.gradle.plugins:android-junit5:${JUnit5.pluginVersion}")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}