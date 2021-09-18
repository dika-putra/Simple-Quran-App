package com.dika.quranapp.di

import com.dika.quranapp.data.remote.services.ChapterService
import com.dika.quranapp.data.remote.services.VerseService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun provideChapterService(retrofit: Retrofit): ChapterService =
        retrofit.create(ChapterService::class.java)

    @Provides
    @Singleton
    fun provideVerseService(retrofit: Retrofit): VerseService =
        retrofit.create(VerseService::class.java)
}