package com.dika.quranapp.data.mapper

import com.dika.quranapp.data.local.model.WordEntity
import com.dika.quranapp.data.remote.model.WordResponse
import com.dika.quranapp.domain.model.Word

fun WordResponse.toEntity() = WordEntity(
    id = id,
    position = position,
    text = text,
    translation = translation.toEntity()
)

fun WordEntity.toModel() = Word(
    id = id,
    position = position,
    text = text,
    translation = translation.toModel()
)