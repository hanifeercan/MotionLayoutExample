package com.hercan.motionlayoutexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hercan.motionlayoutexample.core.common.ResponseState
import com.hercan.motionlayoutexample.core.domain.GetCartoonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val getCartoonsUseCase: GetCartoonsUseCase
) : ViewModel() {

    private val _cartoonsScreenUiState = MutableLiveData(CartoonListScreenUiState.initial())
    val cartoonsScreenUiState: LiveData<CartoonListScreenUiState> get() = _cartoonsScreenUiState

    fun getAllBooks() {
        viewModelScope.launch {
            getCartoonsUseCase().collect { responseState ->
                when (responseState) {
                    is ResponseState.Error -> {
                        _cartoonsScreenUiState.postValue(
                            CartoonListScreenUiState(
                                isError = true, errorMessage = responseState.message
                            )
                        )
                    }

                    is ResponseState.Loading -> {
                        _cartoonsScreenUiState.postValue(CartoonListScreenUiState(isLoading = true))
                    }

                    is ResponseState.Success -> {
                        _cartoonsScreenUiState.postValue(CartoonListScreenUiState(responseState.data))
                    }
                }
            }
        }
    }
}