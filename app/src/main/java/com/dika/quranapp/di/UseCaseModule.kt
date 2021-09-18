package com.dika.quranapp.di

import com.dika.quranapp.domain.usecase.GetChapters
import com.dika.quranapp.domain.usecase.GetChaptersImpl
import com.dika.quranapp.domain.usecase.GetVerses
import com.dika.quranapp.domain.usecase.GetVersesImpl
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
}