package com.danchoo.date.presentation.di

import com.danchoo.date.data.datasource.local.ContentsLocalDataSource
import com.danchoo.date.data.datasource.local.ContentsLocalDataSourceImpl
import com.danchoo.date.data.db.dao.ContentsDao
import com.danchoo.date.data.pagingsource.ContentsPagingSource
import com.danchoo.date.data.repository.ContentsRepositoryImpl
import com.danchoo.date.domain.inspactor.usecase.main.contents.ContentsPagingUseCase
import com.danchoo.date.domain.repository.ContentsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ContentsModule {

    @Provides
    fun provideContentsPagingUseCase(repository: ContentsRepository): ContentsPagingUseCase {
        return ContentsPagingUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideContentsRepository(
        localDatasource: ContentsLocalDataSource
    ): ContentsRepository {
        return ContentsRepositoryImpl(localDatasource)
    }

    @Provides
    fun provideContentsPagingSource(localDataSource: ContentsLocalDataSource): ContentsPagingSource {
        return ContentsPagingSource(localDataSource)
    }

    @Singleton
    @Provides
    fun provideContentsLocalDataSource(contentsDao: ContentsDao): ContentsLocalDataSource {
        return ContentsLocalDataSourceImpl(contentsDao)
    }
}