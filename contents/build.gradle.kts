plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
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

}