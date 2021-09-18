package com.dika.quranapp.di

import com.dika.quranapp.domain.usecase.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class UseCaseModule {
    @Binds
    @Singleton
    abstract fun bindGetChaptersUseCase(getChapterImpl: GetChaptersImpl): GetChapters

    @Binds
    @Singleton
    abstract fun bindGetVerseUseCase(getVersesImpl: GetVersesImpl): GetVerses

    @Binds
    @Singleton
    abstract fun bindGetChapterInfoCase(getChapterInfoImpl: GetChapterInfoImpl): GetChapterInfo
}