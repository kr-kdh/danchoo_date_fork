plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    default()
}

dependencies {

    Retrofit.run {
        implementation(retrofit)
        implementation(converterMoshi)
        implementation(okhttp)
    }


//
//    // retrofit
//    implementation "com.squareup.retrofit2:retrofit:$retrofit_version"
//    implementation "com.squareup.retrofit2:converter-moshi:$retrofit_version"
//
//    implementation 'androidx.core:core-ktx:1.6.0'
//    implementation 'androidx.appcompat:appcompat:1.3.1'
//    implementation 'com.google.android.material:material:1.4.0'
//    testImplementation 'junit:junit:4.13.2'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
}