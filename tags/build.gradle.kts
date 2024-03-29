plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    default()
}


dependencies {
    AndroidX.Room.run {
        kapt(compiler)
        implementation(ktx)
        implementation(runtime)
        implementation(paging)
        annotationProcessor(compiler)
    }

    //
//    implementation 'androidx.core:core-ktx:1.6.0'
//    implementation 'androidx.appcompat:appcompat:1.3.1'
//    implementation 'com.google.android.material:material:1.4.0'
//    testImplementation 'junit:junit:4.+'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
//
//    // room
//    kapt "androidx.room:room-compiler:$room_version"
//    implementation "androidx.room:room-ktx:$room_version"
//    implementation "androidx.room:room-runtime:$room_version"
//    implementation "androidx.sqlite:sqlite-ktx:2.1.0"
//    annotationProcessor "androidx.room:room-compiler:$room_version"
}