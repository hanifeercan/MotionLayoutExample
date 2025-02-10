package com.hercan.motionlayoutexample

import androidx.lifecycle.ViewModel
import com.hercan.motionlayoutexample.core.domain.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hercan.motionlayoutexample.core.common.ResponseState
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase
) : ViewModel() {

    private val _characterScreenUiState = MutableLiveData(CharacterListScreenUiState.initial())
    val characterScreenUiState: LiveData<CharacterListScreenUiState> get() = _characterScreenUiState

    fun getAllBooks() {
        viewModelScope.launch {
            getCharactersUseCase().collect { responseState ->
                when (responseState) {
                    is ResponseState.Error -> {
                        _characterScreenUiState.postValue(
                            CharacterListScreenUiState(
                                isError = true, errorMessage = responseState.message
                            )
                        )
                    }

                    is ResponseState.Loading -> {
                        _characterScreenUiState.postValue(CharacterListScreenUiState(isLoading = true))
                    }

                    is ResponseState.Success -> {
                        _characterScreenUiState.postValue(CharacterListScreenUiState(responseState.data))
                    }
                }
            }
        }
    }
}