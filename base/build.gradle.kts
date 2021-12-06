plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    default()
}

dependencies {
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
}