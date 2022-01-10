package com.danchoo.date.presentation.di

import android.content.Context
import com.danchoo.date.presentation.ui.components.main.gallery.data.datasource.GalleryDataSource
import com.danchoo.date.presentation.ui.components.main.gallery.data.datasource.GalleryDataSourceImpl
import com.danchoo.date.presentation.ui.components.main.gallery.data.repository.GalleryRepositoryImpl
import com.danchoo.date.presentation.ui.components.main.gallery.domain.repository.GalleryRepository
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
}