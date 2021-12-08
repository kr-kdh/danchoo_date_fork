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
}

dependencies {

    AndroidX.Compose.run {
        implementation(ui)
        implementation(uiUtil)
        implementation(runtime)
        implementation(material)
        implementation(animation)
        implementation(tooling)
        implementation(iconsExtended)
    }

    AndroidX.ConstraintLayout.run {
        implementation(constraintLayout)
    }

    AndroidX.Navigation.run {
        implementation(compose)
        implementation(runtimeKtx)
        implementation(uiKtx)
        implementation(fragmentKtx)
    }

    Accompanist.run {
        implementation(systemUiController)
        implementation(navigationAnimation)
    }

    Coil.run {
        implementation(coil)
    }
}