package com.danchoo.date.di

import com.danchoo.date.data.datasource.local.ContentsLocalDataSource
import com.danchoo.date.data.datasource.local.ContentsLocalDataSourceImpl
import com.danchoo.date.data.datasource.pagingsource.ContentsPagingSource
import com.danchoo.date.data.db.dao.ContentsDao
import com.danchoo.date.data.repository.ContentsRepositoryImpl
import com.danchoo.date.domain.inspactor.usecase.main.contents.ContentsListInsertUseCase
import com.danchoo.date.domain.inspactor.usecase.main.contents.ContentsPagingUseCase
import com.danchoo.date.domain.repository.ContentsRepository
import com.danchoo.date.presentation.di.ContentsModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [ContentsModule::class]
)
object ContentsTestModule {

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