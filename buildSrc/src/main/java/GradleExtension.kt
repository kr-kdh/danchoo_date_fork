import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.JavaVersion

object Config {
    const val APPLICATION_ID = "com.danchoo.date"
    const val COMPILE_SDK = 31
    const val BUILD_TOOL_VERSION = "31.0.3"
    const val MIN_SDK = 23
    const val TARGET_SDK = 31
    const val VERSION_NAME = "1.0"
    const val VERSION_CODE = 1

    const val TEST_INSTRUMENTATION_RUNNER = "com.danchoo.date.CustomTestRunner"

    val JAVA_VERSION = JavaVersion.VERSION_11

    const val COMPOSE_VERSION = AndroidX.Compose.version
}

fun BaseAppModuleExtension.default() {
    compileSdk = Config.COMPILE_SDK
//    buildToolsVersion = AppModule.BUILD_TOOL_VERSION

    defaultConfig.run {
        applicationId = Config.APPLICATION_ID
        minSdk = Config.MIN_SDK
        targetSdk  = Config.TARGET_SDK
        versionCode = Config.VERSION_CODE
        versionName = Config.VERSION_NAME

        testInstrumentationRunner = Config.TEST_INSTRUMENTATION_RUNNER
//        testInstrumentationRunnerArgument "runnerBuilder", "de.mannodermaus.junit5.AndroidJUnit5Builder"
//        testInstrumentationRunnerArguments clearPackageData: 'true'
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
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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
//    buildToolsVersion = AppModule.BUILD_TOOL_VERSION

    defaultConfig.run {
        minSdk =  Config.MIN_SDK
        targetSdk = Config.TARGET_SDK

        testInstrumentationRunner = Config.TEST_INSTRUMENTATION_RUNNER
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
    }
}
