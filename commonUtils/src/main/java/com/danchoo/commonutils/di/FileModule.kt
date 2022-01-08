package com.danchoo.commonutils.di

import android.content.Context
import com.danchoo.commonutils.file.FileConfiguration
import com.danchoo.commonutils.file.FileConfigurationImpl
import com.danchoo.commonutils.file.domain.inspector.SaveBitmapUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object FileModule {

    @Provides
    fun provideSaveBitmapUseCase(): SaveBitmapUseCase {
        return SaveBitmapUseCase()
    }

    @Provides
    fun provideFileConfiguration(
        @ApplicationContext context: Context
    ): FileConfiguration {
        return FileConfigurationImpl(context)
    }
}