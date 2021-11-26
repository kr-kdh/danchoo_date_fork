object Classpath {
    const val gradle = "com.android.tools.build:gradle:7.0.3"

    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0"

    const val googleService = "com.google.gms:google-services:4.3.10"
    const val hiltAndroidGradlePlugin =
        "com.google.dagger:hilt-android-gradle-plugin:${Hilt.version}"

//    const val ANDROID_JUNIT5 = "de.mannodermaus.gradle.plugins:android-junit5:1.6.2.0"
}


object AndroidX {
    const val coreKtx = "androidx.core:core-ktx:1.6.0"
    const val appcompat = "androidx.appcompat:appcompat:1.3.1"
    const val multidex = "androidx.multidex:multidex:2.0.1"
    const val coreTesting = "androidx.arch.core:core-testing:2.1.0"

    object Compose {
        const val version = "1.0.4"

        const val layout = "androidx.compose.foundation:foundation-layout:$version"
        const val ui = "androidx.compose.ui:ui:$version"
        const val uiUtil = "androidx.compose.ui:ui-util:$version"
        const val runtime = "androidx.compose.runtime:runtime:$version"
        const val material = "androidx.compose.material:material:$version"
        const val animation = "androidx.compose.animation:animation:$version"
        const val tooling = "androidx.compose.ui:ui-tooling:$version"
        const val iconsExtended = "androidx.compose.material:material-icons-extended:$version"
        const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:$version"
        const val uiTest = "androidx.compose.ui:ui-test-junit4:$version"
    }

    object Activity {
        const val compose = "androidx.activity:activity-compose:1.3.1"
    }

    object ConstraintLayout {
        const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:1.0.0-rc01"
    }

    object Lifecycle {
        private const val version = "2.4.0-rc01"
        const val core = "androidx.lifecycle:lifecycle-livedata-core-ktx:$version"
        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
        const val ViewModelSavedSate = "androidx.lifecycle:lifecycle-viewmodel-savedstate:$version"
    }

    object Navigation {
        private const val version = "2.3.0"
        const val compose = "androidx.navigation:navigation-compose:$version"
        const val runtimeKtx = "androidx.navigation:navigation-runtime-ktx:$version"
        const val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"
        const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
    }

    object Room {
        private const val version = "2.3.0"

        const val compiler = "androidx.room:room-compiler:$version"
        const val ktx = "androidx.room:room-ktx:$version"
        const val runtime = "androidx.room:room-runtime:$version"
    }

    object Paging {
        private const val version = "3.0.1"
        const val ktx = "androidx.paging:paging-runtime-ktx:$version"
        const val compose = "androidx.paging:paging-compose:1.0.0-alpha14"
    }

    object Test {
        private const val version = "1.3.0"
        const val runner = "androidx.test:runner:$version"
        const val rules = "androidx.test:rules:$version"
        const val junit = "androidx.test.ext:junit-ktx:1.1.2"
        const val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"
        const val room = "androidx.room:room-testing:2.3.0"
    }
}

object Accompanist {
    private const val version = "0.18.0"
    const val inserts = "com.google.accompanist:accompanist-insets:$version"
    const val systemUiController = "com.google.accompanist:accompanist-systemuicontroller:$version"
    const val navigationAnimation =
        "com.google.accompanist:accompanist-navigation-animation:$version"

    const val pager = "com.google.accompanist:accompanist-pager:$version"
    const val pagerIndicators = "com.google.accompanist:accompanist-pager-indicators:$version"
}

object Coil {
    const val coil = "io.coil-kt:coil-compose:1.3.2"
}

object Retrofit {
    const val version = "2.9.0"
    const val retrofit = "com.squareup.retrofit2:retrofit:$version"
    const val converterMoshi = "com.squareup.retrofit2:converter-moshi:$version"
    const val okhttp = "com.squareup.okhttp3:okhttp:5.0.0-alpha.2"
}

object Moshi {
    const val moshi = "com.squareup.moshi:moshi-kotlin:1.12.0"
}

object Google {
    const val tasks = "com.google.android.gms:play-services-tasks:17.2.1"
    const val ads = "com.google.android.gms:play-services-ads:20.4.0"

    private const val materialVersion = "1.4.0"
    const val material = "com.google.android.material:material:$materialVersion"
}

object Firebase {
    const val bom = "com.google.firebase:firebase-bom:28.4.2"
    const val analytics = "com.google.firebase:firebase-analytics-ktx"
    const val fireStore = "com.google.firebase:firebase-firestore-ktx"
}

object Hilt {
    const val version = "2.39.1"

    const val android = "com.google.dagger:hilt-android:$version"
    const val compiler = "com.google.dagger:hilt-compiler:$version"
    const val testing = "com.google.dagger:hilt-android-testing:$version"

    const val compose = "androidx.hilt:hilt-navigation-compose:1.0.0-alpha03"
}

object Coroutines {
    private const val version = "1.3.9"
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
}

object Timber {
    const val timber = "com.jakewharton.timber:timber:5.0.1"
}

object AssertJ {
    const val core = "org.assertj:assertj-core:3.18.0"
}

object JUnit4 {
    private const val version = "4.13.2"

    const val api = "org.junit.jupiter:junit-jupiter-api:$version"
    const val engine = "org.junit.jupiter:junit-jupiter-engine:$version"

    const val params = "org.junit.jupiter:junit-jupiter-params:$version"
}

object JUnit5 {
    /**
     * junit5 hilt 에서 사용불가능
     */
    private const val version = "5.8.0"
    private const val junit5Version = "1.3.0"

    const val api = "org.junit.jupiter:junit-jupiter-api:$version"
    const val engine = "org.junit.jupiter:junit-jupiter-engine:$version"

    const val params = "org.junit.jupiter:junit-jupiter-params:$version"
    const val testCore = "de.mannodermaus.junit5:android-test-core:$junit5Version"
    const val runner = "de.mannodermaus.junit5:android-test-runner:$junit5Version"
}

object Mockito {
    private const val version = "2.24.5"
    const val mock = "org.mockito:mockito-android:$version"
    const val mockInline = "org.mockito:mockito-inline:$version"
}

