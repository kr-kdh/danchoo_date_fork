plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")

//    id 'de.mannodermaus.android-junit5'
}

android {
    default()

    kotlinOptions {
        jvmTarget = Config.JAVA_VERSION.toString()

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

// Allow references to generated code
kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(":contents"))
    implementation(project(":base"))
    implementation(project(":components"))
    implementation(project(":commonUtils"))
    implementation(project(":retrofitUtils"))
    implementation(project(":category"))
    implementation(project(":tags"))
    implementation(project(":gallery"))
    testImplementation("junit:junit:4.12")

    AndroidX.run {
        implementation(coreKtx)
        implementation(appcompat)
        androidTestImplementation(coreTesting)
    }

    AndroidX.Activity.run {
        implementation(compose)
    }

    AndroidX.Lifecycle.run {
        implementation(viewModelKtx)
        implementation(viewModelCompose)
        implementation(ViewModelSavedSate)
    }

    AndroidX.Room.run {
        kapt(compiler)
        implementation(ktx)
        implementation(runtime)
        implementation(paging)
        annotationProcessor(compiler)
    }

    Accompanist.run {
        implementation(inserts)
        implementation(pager)
        implementation(pagerIndicators)
        implementation(drawablePainter)
        implementation(flowLayout)
    }


    Retrofit.run {
        implementation(retrofit)
        implementation(converterMoshi)
        implementation(okhttp)
    }

    Moshi.run {
        implementation(moshi)
    }

    AndroidX.Paging.run {
        implementation(ktx)
        implementation(compose)
    }

    Hilt.run {
        implementation(android)
        implementation(compose)
        kapt(compiler)
        androidTestImplementation(testing)
    }

//    Coroutines.run {
//        implementation(core)
//        implementation(android)
//        androidTestImplementation(test)
//    }

//    Mockito.run {
//        androidTestImplementation(mock)
//        androidTestImplementation(mockInline)
//    }

    Google.run {
        implementation(material)
    }

    Glide.run {
        implementation(glide)
        kapt(compiler)
    }

    AndroidX.ConstraintLayout.run {
        implementation(constraintLayout)
    }

    GlideImage.run {
        implementation(glide)
    }
//    AndroidX.Test.run {
//        androidTestImplementation(runner)
//        androidTestImplementation(rules)
//        androidTestImplementation(espressoCore)
//        androidTestImplementation(room)
//
//        testImplementation(runner)
//        testImplementation(rules)
//        testImplementation(room)
//    }
//
//    JUnit4.run {
//        androidTestImplementation(api)
//        androidTestImplementation(engine)
//        androidTestImplementation(params)
//    }

    AndroidX.Test.run {
        androidTestImplementation(runner)
        androidTestImplementation(room)
    }

    JUnit5.run {
        androidTestImplementation(api)
        androidTestImplementation(testCore)
        androidTestImplementation(params)

        androidTestRuntimeOnly(runner)
        androidTestRuntimeOnly(engine)
    }
}