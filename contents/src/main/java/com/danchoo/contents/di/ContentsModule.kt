package com.danchoo.contents.di

import com.danchoo.contents.data.datasource.local.ContentsLocalDataSource
import com.danchoo.contents.data.datasource.local.ContentsLocalDataSourceImpl
import com.danchoo.contents.data.db.dao.ContentsDao
import com.danchoo.contents.data.repository.ContentsRepositoryImpl
import com.danchoo.contents.domain.inspector.usecase.ContentsListInsertUseCase
import com.danchoo.contents.domain.inspector.usecase.ContentsPagingUseCase
import com.danchoo.contents.domain.repository.ContentsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
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
    fun provideContentsListInsertUseCase(
        repository: ContentsRepository,
        dispatcher: CoroutineDispatcher
    ): ContentsListInsertUseCase {
        return ContentsListInsertUseCase(repository, dispatcher)
    }


//    @Provides
//    fun provideContentsPagingSource(localDataSource: ContentsLocalDataSource): ContentsPagingSource {
//        return ContentsPagingSource(localDataSource)
//    }

    @Singleton
    @Provides
    fun provideContentsLocalDataSource(contentsDao: ContentsDao): ContentsLocalDataSource {
        return ContentsLocalDataSourceImpl(contentsDao)
    }
}