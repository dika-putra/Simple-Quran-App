package com.dika.quranapp.data.mapper

import com.dika.quranapp.data.local.model.TranslationEntity
import com.dika.quranapp.data.remote.model.TranslationResponse
import com.dika.quranapp.domain.model.Translation

fun TranslationResponse.toEntity() = TranslationEntity(text)
fun TranslationEntity.toModel() = Translation(text)
