package com.hercan.motionlayoutexample

import com.hercan.motionlayoutexample.core.data.model.CharacterModel

data class CharacterListScreenUiState(
    val characters: List<CharacterModel> = emptyList(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String? = ""
) {
    companion object {
        fun initial() = CharacterListScreenUiState(isLoading = true)
    }
}