package com.danchoo.commonutils.di

import android.content.Context
import com.danchoo.commonutils.data.datasource.FileLocalDataSource
import com.danchoo.commonutils.data.datasource.FileLocalDataSourceImpl
import com.danchoo.commonutils.data.repository.FileRepositoryImpl
import com.danchoo.commonutils.file.FileConfiguration
import com.danchoo.commonutils.file.FileConfigurationImpl
import com.danchoo.commonutils.file.domain.inspector.SaveBitmapUseCase
import com.danchoo.commonutils.file.domain.inspector.SaveFileUseCase
import com.danchoo.commonutils.file.domain.repository.FileRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object FileModule {

    @Provides
    fun provideSaveBitmapUseCase(): SaveBitmapUseCase {
        return SaveBitmapUseCase(Dispatchers.IO)
    }

    @Provides
    fun provideFileConfiguration(
        @ApplicationContext context: Context
    ): FileConfiguration {
        return FileConfigurationImpl(context)
    }

    @Provides
    fun provideSaveFileUseCase(
        fileRepository: FileRepository
    ): SaveFileUseCase {
        return SaveFileUseCase(fileRepository, Dispatchers.IO)
    }

    @Provides
    fun provideFileRepository(
        localDataSource: FileLocalDataSource
    ): FileRepository {
        return FileRepositoryImpl(localDataSource)
    }

    @Provides
    fun provideFileLocalDataSource(
        @ApplicationContext context: Context
    ): FileLocalDataSource {
        return FileLocalDataSourceImpl(context)
    }
}