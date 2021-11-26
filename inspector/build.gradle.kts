plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    default()
}

dependencies {

    Coroutines.run {
        implementation(core)
        implementation(android)
        androidTestImplementation(test)
    }


    AndroidX.Lifecycle.run {
        implementation(core)
    }
}