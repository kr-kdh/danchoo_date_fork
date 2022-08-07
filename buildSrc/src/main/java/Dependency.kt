object AndroidX {
    private const val coreVersion = "1.8.0"
    private const val appcompatVersion = "1.4.2"

    const val coreKtx = "androidx.core:core-ktx:$coreVersion"
    const val appcompat = "androidx.appcompat:appcompat:$appcompatVersion"
    const val multidex = "androidx.multidex:multidex:2.0.1"
    const val coreTesting = "androidx.arch.core:core-testing:2.1.0"

    object Compose {
        const val compilerVersion = "1.2.0"
        const val version = "1.2.0-rc03"
        const val layout = "androidx.compose.foundation:foundation-layout:$version"
        const val ui = "androidx.compose.ui:ui:$version"
        const val uiUtil = "androidx.compose.ui:ui-util:$version"
        const val runtime = "androidx.compose.runtime:runtime:$version"
        const val material = "androidx.compose.material:material:$version"
        const val foundation = "androidx.compose.foundation:foundation:$version"

        const val tooling = "androidx.compose.ui:ui-tooling:$version"
        const val iconsExtended = "androidx.compose.material:material-icons-extended:$version"
        const val runtimeLivedata = "androidx.compose.runtime:runtime-livedata:$version"
        const val uiTest = "androidx.compose.ui:ui-test:$version"
        const val uiTestJunit = "androidx.compose.ui:ui-test-junit4:$version"


        const val animation = "androidx.compose.animation:animation:$version"
        const val animationGraphics = "androidx.compose.animation:animation-graphics:$version"
        const val animationCore = "androidx.compose.animation:animation-core:$version"
        const val uiTestManifest = "androidx.compose.ui:ui-test-manifest:$version"
    }

    object Activity {
        private const val version = "1.5.1"
        const val compose = "androidx.activity:activity-compose:$version"
    }

    object ConstraintLayout {
        const val constraintLayout = "androidx.constraintlayout:constraintlayout-compose:1.0.1"
    }

    object Lifecycle {
        private const val version = "2.5.1"
        const val core = "androidx.lifecycle:lifecycle-livedata-core-ktx:$version"
        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$version"
        const val ViewModelSavedSate = "androidx.lifecycle:lifecycle-viewmodel-savedstate:$version"
        const val runtime = "androidx.lifecycle:lifecycle-runtime-ktx:$version"

    }

    object Navigation {
        private const val version = "2.5.1"
        const val compose = "androidx.navigation:navigation-compose:$version"
        const val runtimeKtx = "androidx.navigation:navigation-runtime-ktx:$version"
        const val uiKtx = "androidx.navigation:navigation-ui-ktx:$version"
        const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:$version"
    }

    object Room {
        private const val version = "2.4.3"

        const val compiler = "androidx.room:room-compiler:$version"
        const val ktx = "androidx.room:room-ktx:$version"
        const val runtime = "androidx.room:room-runtime:$version"
        const val paging = "androidx.room:room-paging:$version"
    }

    object Paging {
        private const val version = "3.1.1"
        const val ktx = "androidx.paging:paging-runtime-ktx:$version"
        const val compose = "androidx.paging:paging-compose:1.0.0-alpha15"
    }

    object Test {
        private const val version = "1.4.0"
        const val runner = "androidx.test:runner:$version"
        const val rules = "androidx.test:rules:$version"
        const val junit = "androidx.test.ext:junit-ktx:1.1.3"
        const val espressoCore = "androidx.test.espresso:espresso-core:3.4.0"
        const val room = "androidx.room:room-testing:2.3.0"
    }
}

object Accompanist {
    private const val version = "0.25.0"
    const val inserts = "com.google.accompanist:accompanist-insets:$version"
    const val systemUiController = "com.google.accompanist:accompanist-systemuicontroller:$version"
    const val navigationAnimation =
        "com.google.accompanist:accompanist-navigation-animation:$version"

    const val pager = "com.google.accompanist:accompanist-pager:$version"
    const val pagerIndicators = "com.google.accompanist:accompanist-pager-indicators:$version"
    const val permission = "com.google.accompanist:accompanist-permissions:$version"

    const val drawablePainter = "com.google.accompanist:accompanist-drawablepainter:$version"
    const val flowLayout = "com.google.accompanist:accompanist-flowlayout:$version"
}

object Retrofit {
    private const val version = "2.9.0"
    const val retrofit = "com.squareup.retrofit2:retrofit:$version"
    const val converterMoshi = "com.squareup.retrofit2:converter-moshi:$version"
    const val okhttp = "com.squareup.okhttp3:okhttp:5.0.0-alpha.2"
}

object Okhttp {
    private const val version = "4.10.0"

    const val okhttp = "com.squareup.okhttp3:okhttp:$version"
    const val mockWebserver = "com.squareup.okhttp3:mockwebserver:$version"
}

object Moshi {
    const val moshi = "com.squareup.moshi:moshi-kotlin:1.13.0"
}

object Google {
    const val tasks = "com.google.android.gms:play-services-tasks:18.0.0"
    const val ads = "com.google.android.gms:play-services-ads:20.5.0"

    private const val materialVersion = "1.6.1"
    const val material = "com.google.android.material:material:$materialVersion"

    private const val version = "1.1.3"
    const val truth = "com.google.truth:truth:$version"
}

object Firebase {
    const val bom = "com.google.firebase:firebase-bom:29.0.22"
    const val analytics = "com.google.firebase:firebase-analytics-ktx"
    const val fireStore = "com.google.firebase:firebase-firestore-ktx"
}

object Hilt {
    const val version = "2.43.2"

    const val android = "com.google.dagger:hilt-android:$version"
    const val compiler = "com.google.dagger:hilt-compiler:$version"
    const val testing = "com.google.dagger:hilt-android-testing:$version"

    const val compose = "androidx.hilt:hilt-navigation-compose:1.0.0"
}

object Coroutines {
    private const val version = "1.6.4"
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
}

object Timber {
    const val timber = "com.jakewharton.timber:timber:5.0.1"
}

object JUnit4 {
    private const val version = "4.13.2"

    const val junit = "junit:junit:$version"
    const val api = "org.junit.jupiter:junit-jupiter-api:$version"
    const val engine = "org.junit.jupiter:junit-jupiter-engine:$version"

    const val params = "org.junit.jupiter:junit-jupiter-params:$version"
}

object MockK {
    private const val version = "1.12.5"
    const val mockk = "io.mockk:mockk:$version"
}

object JUnit5 {
    /**
     * junit5 hilt 에서 사용불가능
     */
    private const val version = "5.9.0"
    private const val junit5Version = "1.3.0"
    const val pluginVersion = "1.8.2.0"

    const val api = "org.junit.jupiter:junit-jupiter-api:$version"
    const val engine = "org.junit.jupiter:junit-jupiter-engine:$version"

    const val params = "org.junit.jupiter:junit-jupiter-params:$version"
    const val testCore = "de.mannodermaus.junit5:android-test-core:$junit5Version"
    const val runner = "de.mannodermaus.junit5:android-test-runner:$junit5Version"

    const val hamcrest = "org.hamcrest:hamcrest-library:2.2"


}

object Glide {
    private const val version = "4.13.2"
    const val glide = "com.github.bumptech.glide:glide:$version"
    const val integration = "com.github.bumptech.glide:okhttp3-integration:$version"
    const val compiler = "com.github.bumptech.glide:compiler:$version"
    const val webpDecoder = "com.github.zjupure:webpdecoder:2.0.$version"
    const val transformations = "jp.wasabeef:glide-transformations:4.3.0"
}


object GlideImage {
    private const val version = "1.2.2.3"
    const val glide = "com.github.danchoo21:glide-image:$version"
}

