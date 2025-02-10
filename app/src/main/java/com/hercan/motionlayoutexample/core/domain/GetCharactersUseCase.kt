package com.hercan.motionlayoutexample.core.domain

import com.hercan.motionlayoutexample.core.common.ResponseState
import com.hercan.motionlayoutexample.core.data.model.CharacterModel
import com.hercan.motionlayoutexample.core.data.repo.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(): Flow<ResponseState<List<CharacterModel>>> {
        return repository.getCharacters()
    }
}