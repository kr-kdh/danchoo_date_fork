import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.JavaVersion

object Config {
    const val APPLICATION_ID = "com.danchoo.date"
    const val COMPILE_SDK = 33
    const val BUILD_TOOL_VERSION = "33.0.0"
    const val MIN_SDK = 23
    const val TARGET_SDK = 33
    const val VERSION_NAME = "1.0"
    const val VERSION_CODE = 1

    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"

    val JAVA_VERSION = JavaVersion.VERSION_1_8

    const val COMPOSE_VERSION = AndroidX.Compose.compilerVersion
}

fun BaseAppModuleExtension.default() {
    compileSdk = Config.COMPILE_SDK
    buildToolsVersion = Config.BUILD_TOOL_VERSION

    defaultConfig.run {
        applicationId = Config.APPLICATION_ID
        minSdk = Config.MIN_SDK
        targetSdk = Config.TARGET_SDK
        versionCode = Config.VERSION_CODE
        versionName = Config.VERSION_NAME

        testInstrumentationRunner = Config.TEST_INSTRUMENTATION_RUNNER
        testInstrumentationRunnerArguments += mapOf(
            "clearPackageData" to "true",
            "runnerBuilder" to "de.mannodermaus.junit5.AndroidJUnit5Builder"
        )
    }

    buildTypes.run {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions.run {
        sourceCompatibility = Config.JAVA_VERSION
        targetCompatibility = Config.JAVA_VERSION
    }

    composeOptions.run {
        kotlinCompilerExtensionVersion = Config.COMPOSE_VERSION
    }

    packagingOptions.run {
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        resources.excludes.add("/META-INF/LICENSE.md")
        resources.excludes.add("/META-INF/LICENSE-notice.md")
    }

    buildFeatures.run {
        compose = true

        // Disable unused AGP features
        aidl = false
        renderScript = false
        resValues = false
        shaders = false
    }
}

fun LibraryExtension.default() {
    compileSdk = Config.COMPILE_SDK
    buildToolsVersion = Config.BUILD_TOOL_VERSION

    defaultConfig.run {
        minSdk = Config.MIN_SDK
        targetSdk = Config.TARGET_SDK

        testInstrumentationRunner = Config.TEST_INSTRUMENTATION_RUNNER
        testInstrumentationRunnerArguments += mapOf(
            "clearPackageData" to "true",
            "runnerBuilder" to "de.mannodermaus.junit5.AndroidJUnit5Builder"
        )
    }

    buildTypes.run {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions.run {
        sourceCompatibility = Config.JAVA_VERSION
        targetCompatibility = Config.JAVA_VERSION
    }

    packagingOptions.run {
        resources.excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        resources.excludes.add("/META-INF/LICENSE.md")
        resources.excludes.add("/META-INF/LICENSE-notice.md")
    }
}
