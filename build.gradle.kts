
plugins {
    id("com.google.dagger.hilt.android") version Hilt.version apply false
}


tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}