package com.dika.quranapp.di

import com.dika.quranapp.data.repository.ChapterRepositoryImpl
import com.dika.quranapp.domain.repository.ChapterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindChapterRepository(chapterRepositoryImpl: ChapterRepositoryImpl): ChapterRepository
}