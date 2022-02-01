plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
}

android {
    default()

    composeOptions.run {
        kotlinCompilerExtensionVersion = Config.COMPOSE_VERSION
    }

    buildFeatures.run {
        compose = true
    }

    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs.plus(
            listOf(
                "-Xopt-in=kotlin.RequiresOptIn",
                "-Xopt-in=kotlin.Experimental",
                "-Xopt-in=androidx.compose.animation.ExperimentalAnimationApi",
                "-Xopt-in=com.google.accompanist.pager.ExperimentalPagerApi",
                "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                "-Xopt-in=com.google.accompanist.permissions.ExperimentalPermissionsApi"
            )
        )
    }
}

dependencies {
    implementation(project(":components"))
    implementation(project(":inspector"))
    implementation(project(":base"))

    AndroidX.Navigation.run {
        implementation(compose)
        implementation(runtimeKtx)
        implementation(uiKtx)
        implementation(fragmentKtx)
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

    GlideImage.run {
        implementation(glide)
    }
}
