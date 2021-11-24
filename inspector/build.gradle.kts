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


//
//    implementation 'androidx.core:core-ktx:1.6.0'
//    implementation 'androidx.appcompat:appcompat:1.3.1'
//    implementation 'com.google.android.material:material:1.4.0'
//    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.1"
//
//
//    testImplementation 'junit:junit:4.13.2'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
}