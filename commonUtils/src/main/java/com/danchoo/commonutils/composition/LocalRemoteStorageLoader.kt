package com.danchoo.commonutils.composition

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf

val LocalRemoteStorageLoader = RemoteStorageLoaderCompositionLocal()

interface RemoteStorageLoader {
    fun getMediaUri(key: String): Uri
}

class RemoteStorageLoaderImpl : RemoteStorageLoader {
    override fun getMediaUri(key: String): Uri {
        return Uri.parse(key)
    }
}

@JvmInline
value class RemoteStorageLoaderCompositionLocal internal constructor(
    private val delegate: ProvidableCompositionLocal<RemoteStorageLoader> = staticCompositionLocalOf { RemoteStorageLoaderImpl() }
) {
    val current: RemoteStorageLoader
        @Composable get() = delegate.current


    infix fun provides(value: RemoteStorageLoader) = delegate provides value
}