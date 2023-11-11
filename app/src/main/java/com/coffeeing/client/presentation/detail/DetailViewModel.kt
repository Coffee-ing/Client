package com.coffeeing.client.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coffeeing.client.domain.model.DetailCoffeeing
import com.coffeeing.client.domain.model.Like
import com.coffeeing.client.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {
    private var _coffeeingDetail = MutableStateFlow<DetailCoffeeing?>(null)
    val coffeeingDetail get() = _coffeeingDetail.asStateFlow()
    private var _likeState = MutableStateFlow<Like?>(null)
    val likeState get() = _likeState.asStateFlow()

    fun getCoffeeingDetail(postId: Int) {
        viewModelScope.launch {
            mainRepository.getCoffeeingDetail(postId)
                .onSuccess {
                    _coffeeingDetail.value = it
                }
                .onFailure { exception: Throwable ->
                    Timber.e(exception.message)
                }
        }
    }

    fun postLike(postId: Int) {
        viewModelScope.launch {
            mainRepository.postLike(postId)
                .onSuccess { like ->
                    _likeState.value = like
                }
                .onFailure { throwable ->
                    Timber.e(throwable.message)
                }
        }
    }
}