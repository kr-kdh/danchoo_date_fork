plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("de.mannodermaus.android-junit5")
}

android {
    default()

    kotlinOptions {
        // Enable experimental coroutines APIs, including Flow
        freeCompilerArgs = freeCompilerArgs.plus(
            listOf(
                "-Xopt-in=kotlin.RequiresOptIn",
                "-Xopt-in=kotlin.Experimental",
                "-Xopt-in=androidx.compose.animation.ExperimentalAnimationApi",
                "-Xopt-in=com.google.accompanist.pager.ExperimentalPagerApi",
                "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                "-Xopt-in=com.google.accompanist.permissions.ExperimentalPermissionsApi",
                "-Xopt-in=androidx.compose.foundation.ExperimentalFoundationApi"
            )
        )
    }
}

dependencies {
    implementation(project(":tags"))
    implementation(project(":inspector"))
    implementation(project(":retrofitUtils"))

    AndroidX.Paging.run {
        implementation(ktx)
        implementation(compose)
    }

    AndroidX.Room.run {
        kapt(compiler)
        implementation(ktx)
        implementation(runtime)
        implementation(paging)
        annotationProcessor(compiler)
    }

    Hilt.run {
        implementation(android)
        implementation(compose)
        kapt(compiler)
        kaptAndroidTest(compiler)
        androidTestImplementation(testing)
    }

    Retrofit.run {
        implementation(retrofit)
        implementation(converterMoshi)
        implementation(okhttp)
    }

    AndroidX.Test.run {
        androidTestImplementation(runner)
        androidTestImplementation(room)

        testImplementation(runner)
    }

    JUnit5.run {
        androidTestImplementation(api)
        androidTestImplementation(testCore)
        androidTestImplementation(params)

        androidTestRuntimeOnly(runner)
        androidTestRuntimeOnly(engine)

        androidTestCompileOnly(hamcrest)

        testImplementation(api)
        testImplementation(testCore)
        testImplementation(params)

        testRuntimeOnly(runner)
        testRuntimeOnly(engine)
        testCompileOnly(hamcrest)
    }

    Mockito.run {
        androidTestCompileOnly(mock)
        androidTestCompileOnly(mockInline)
        androidTestCompileOnly(core)

        testCompileOnly(mock)
        testCompileOnly(mockInline)
        testCompileOnly(mockJupiter)
        testImplementation(core)
    }

    Coroutines.run {
        testImplementation(test)
    }

    Google.run {
        testImplementation(truth)
    }
}