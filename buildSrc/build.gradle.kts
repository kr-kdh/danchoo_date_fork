plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

//plugins {
////    id("com.android.application") version "7.2.1" apply false
////    id("com.android.library") version "7.2.1" apply false
//
////    id("org.jetbrains.kotlin.android") version "1.7.0" apply false
////    id("com.android.application") version "7.2.1" apply false
////    id("com.android.application") version "7.2.1" apply false
//
////    id 'com.android.library' version '7.2.1' apply false
////    id 'org.jetbrains.kotlin.android' version '1.7.0' apply false
////    id 'com.google.dagger.hilt.android' version '2.42' apply false
//}

//plugins {
//    id("com.google.dagger.hilt.android") version Hilt.version apply false
//}
dependencies {
    implementation("com.android.tools.build:gradle:7.2.2")
    implementation(kotlin("gradle-plugin", "1.7.0"))
//    implementation("de.mannodermaus.gradle.plugins:android-junit5:${JUnit5.pluginVersion}")
}
