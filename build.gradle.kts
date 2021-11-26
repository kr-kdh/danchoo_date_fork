buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Classpath.gradle)
        classpath(Classpath.kotlinGradlePlugin)
        classpath(Classpath.googleService)
        classpath(Classpath.hiltAndroidGradlePlugin)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}