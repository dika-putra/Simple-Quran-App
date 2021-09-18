package com.dika.quranapp.di

import com.dika.quranapp.data.repository.ChapterRepositoryImpl
import com.dika.quranapp.domain.usecase.GetChapterImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object UseCaseModule {
    @Singleton
    @Provides
    fun provideGetChapter(repositoryImpl: ChapterRepositoryImpl): GetChapterImpl =
        GetChapterImpl(repositoryImpl)
}