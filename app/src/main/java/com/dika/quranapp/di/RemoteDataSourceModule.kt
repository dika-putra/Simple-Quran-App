package com.dika.quranapp.di

import com.dika.quranapp.data.remote.datasource.ChapterRemoteDataSource
import com.dika.quranapp.data.remote.datasource.ChapterRemoteDataSourceImpl
import com.dika.quranapp.data.remote.datasource.VerseRemoteDataSource
import com.dika.quranapp.data.remote.datasource.VerseRemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RemoteDataSourceModules {
    @Binds
    @Singleton
    abstract fun bindChapterRemoteDataSource(chapterRemoteDataSourceImpl: ChapterRemoteDataSourceImpl): ChapterRemoteDataSource

    @Binds
    @Singleton
    abstract fun bindVerseRemoteDataSource(verseRemoteDataSourceImpl: VerseRemoteDataSourceImpl): VerseRemoteDataSource
}