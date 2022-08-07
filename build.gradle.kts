buildscript {

    dependencies {
        classpath("de.mannodermaus.gradle.plugins:android-junit5:${JUnit5.pluginVersion}")
//        classpath("com.google.dagger:hilt-android-gradle-plugin:${Hilt.version}")
    }
}

plugins {
    id("com.google.dagger.hilt.android") version Hilt.version apply false
}


tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}