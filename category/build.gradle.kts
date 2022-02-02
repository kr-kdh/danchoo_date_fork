plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("de.mannodermaus.android-junit5")
}

android {
    default()
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
    }

    JUnit5.run {
        androidTestImplementation(api)
        androidTestImplementation(testCore)
        androidTestImplementation(params)

        androidTestRuntimeOnly(runner)
        androidTestRuntimeOnly(engine)
    }
}