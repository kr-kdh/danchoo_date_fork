package com.danchoo.date.presentation.common.gallery.di

import android.content.Context
import com.danchoo.date.presentation.common.gallery.data.datasource.GalleryDataSource
import com.danchoo.date.presentation.common.gallery.data.datasource.GalleryDataSourceImpl
import com.danchoo.date.presentation.common.gallery.data.repository.GalleryRepositoryImpl
import com.danchoo.date.presentation.common.gallery.domain.inspector.GalleryPagingUseCase
import com.danchoo.date.presentation.common.gallery.domain.repository.GalleryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object GalleryModule {

    @Provides
    fun provideGalleryRepository(
        dataSource: GalleryDataSource
    ): GalleryRepository {
        return GalleryRepositoryImpl(dataSource)
    }

    @Provides
    fun provideGalleryDataSource(
        @ApplicationContext context: Context
    ): GalleryDataSource {
        return GalleryDataSourceImpl(context)
    }

    @Provides
    fun provideGalleryPagingUseCase(
        repository: GalleryRepository
    ): GalleryPagingUseCase {
        return GalleryPagingUseCase(repository)
    }
}