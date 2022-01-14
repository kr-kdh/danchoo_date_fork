package com.danchoo.date.presentation.ui.common.glide

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool
import com.bumptech.glide.load.engine.cache.ExternalPreferredCacheDiskCacheFactory
import com.bumptech.glide.load.engine.cache.LruResourceCache
import com.bumptech.glide.module.AppGlideModule


@GlideModule
class GlideModule : AppGlideModule() {
    override fun applyOptions(context: Context, builder: GlideBuilder) {

        val bitmapPoolSizeBytes = 1024 * 1024 * 30 // 30mb
        builder.setBitmapPool(LruBitmapPool(bitmapPoolSizeBytes.toLong()))

        val memoryCacheSizeBytes: Long = 1024 * 1024 * 30 // 30mb
        builder.setMemoryCache(LruResourceCache(memoryCacheSizeBytes))

        val diskCacheSizeBytes: Long = 1024 * 1024 * 2000
        builder.setDiskCache(ExternalPreferredCacheDiskCacheFactory(context, diskCacheSizeBytes))
    }

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
    }
}