plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
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
                "-Xopt-in=coil.annotation.ExperimentalCoilApi",
                "-Xopt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
                "-Xopt-in=com.google.accompanist.permissions.ExperimentalPermissionsApi"
            )
        )
    }
}

dependencies {

    AndroidX.Compose.run {
        api(ui)
        api(uiUtil)
        api(runtime)
        api(material)
        api(animation)
        api(tooling)
        api(iconsExtended)
    }

    AndroidX.Navigation.run {
        api(compose)
        api(runtimeKtx)
        api(uiKtx)
        api(fragmentKtx)
    }

    Accompanist.run {
        api(systemUiController)
        api(navigationAnimation)
        implementation(permission)
    }

    Coil.run {
        api(coil)
    }
}