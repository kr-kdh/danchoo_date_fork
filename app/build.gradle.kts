plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")

//    id 'de.mannodermaus.android-junit5'
}

android {
    default()

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()

        // Enable experimental coroutines APIs, including Flow
        freeCompilerArgs = freeCompilerArgs.plus(
            listOf(
                "-Xopt-in=kotlin.RequiresOptIn",
                "-Xopt-in=kotlin.Experimental",
                "-Xopt-in=androidx.compose.animation.ExperimentalAnimationApi"

            )
        )
    }
}

dependencies {
    implementation(project(":contents"))
    implementation(project(":base"))
    implementation(project(":components"))
    implementation(project(":commonUtils"))
    implementation(project(":retrofitUtils"))
    implementation(project(":inspector"))
    implementation(project(":category"))
    implementation(project(":tags"))

    AndroidX.run {
        implementation(coreKtx)
        implementation(appcompat)
        implementation(multidex)
        implementation(coreTesting)
    }

    AndroidX.Compose.run {
        implementation(ui)
        implementation(uiUtil)
        implementation(runtime)
        implementation(material)
        implementation(animation)
        implementation(tooling)
        implementation(iconsExtended)
    }

    AndroidX.Activity.run {
        implementation(compose)
    }

    AndroidX.ConstraintLayout.run {
        implementation(constraintLayout)
    }

    AndroidX.Lifecycle.run {
        implementation(viewModelKtx)
        implementation(viewModelCompose)
        implementation(ViewModelSavedSate)
    }

    AndroidX.Navigation.run {
        implementation(compose)
        implementation(runtimeKtx)
        implementation(uiKtx)
        implementation(fragmentKtx)
    }

    AndroidX.Room.run {
        kapt(compiler)
        implementation(ktx)
        implementation(runtime)
        annotationProcessor(compiler)
    }

    Accompanist.run {
        implementation(inserts)
        implementation(systemUiController)
        implementation(navigationAnimation)
        implementation(pager)
        implementation(pagerIndicators)
        implementation(permission)
    }

    Coil.run {
        implementation(coil)
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
        kaptAndroidTest(compiler)
        androidTestImplementation(testing)
    }

    Coroutines.run {
        implementation(core)
        implementation(android)
        androidTestImplementation(test)
    }

    Mockito.run {
        androidTestImplementation(mock)
        androidTestImplementation(mockInline)
    }

    Google.run {
        implementation(material)
    }

//    AndroidX.Test.run {
//        androidTestImplementation(runner)
//        androidTestImplementation(rules)
//        androidTestImplementation(junit)
//        androidTestImplementation(espressoCore)
//        androidTestImplementation(room)
//
//        testImplementation(runner)
//        testImplementation(rules)
//        testImplementation(junit)
//        testImplementation(room)
//    }
//
//    JUnit4.run {
//        androidTestImplementation(api)
//        androidTestImplementation(engine)
//        androidTestImplementation(params)
//    }
}