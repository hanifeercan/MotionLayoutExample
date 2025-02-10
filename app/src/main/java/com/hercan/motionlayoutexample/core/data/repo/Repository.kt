package com.hercan.motionlayoutexample.core.data.repo

import com.hercan.motionlayoutexample.core.common.ResponseState
import com.hercan.motionlayoutexample.core.data.model.CharacterModel
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getCharacters(): Flow<ResponseState<List<CharacterModel>>>
}