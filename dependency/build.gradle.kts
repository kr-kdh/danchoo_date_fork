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
    // AndroidX
    implementation("androidx.core:core-ktx:$1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("androidx.multidex:multidex:2.0.1")
    implementation("androidx.arch.core:core-testing:2.1.0")


    // Compose
    implementation("androidx.compose.foundation:foundation-layout:1.0.5")

    // Activity
    implementation("androidx.activity:activity-compose:1.4.0")

    // ConstraintLayout
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.0-rc02")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-livedata-core-ktx:2.4.0")

    // Navigation
    implementation("androidx.navigation:navigation-compose:2.3.0")

    // Room
    implementation("androidx.room:room-compiler:2.3.0")


    // Paging
    implementation("androidx.paging:paging-runtime-ktx:3.1.0")
    implementation("androidx.paging:paging-compose:1.0.0-alpha14")

    // Test
    implementation("androidx.test:runner:1.4.0")
    implementation("androidx.test.ext:junit-ktx:1.1.3")
    implementation("androidx.test.espresso:espresso-core:3.4.0")
    implementation("androidx.room:room-testing:2.3.0")

    // Accompanist
    implementation("com.google.accompanist:accompanist-insets:0.18.0")
    implementation("com.google.accompanist:accompanist-permissions:0.20.3")

    // Coil
    implementation("io.coil-kt:coil-compose:1.3.2")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")

    // Moshi
    implementation("com.squareup.moshi:moshi-kotlin:1.12.0")


    // Google
    implementation("com.google.android.gms:play-services-tasks:18.0.0")
    implementation("com.google.android.gms:play-services-ads:20.5.0")
    implementation("com.google.android.material:material:1.4.0")

    // Firebase
    implementation("com.google.firebase:firebase-bom:29.0.2")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.39.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0-beta01")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")

    // Timber
    implementation("com.jakewharton.timber:timber:5.0.1")

    // JUnit4
    implementation("org.junit.jupiter:junit-jupiter-api:4.13.2")

    // Mockito
    implementation("org.mockito:mockito-android:2.24.5")
}