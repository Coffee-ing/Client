package com.coffeeing.client.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coffeeing.client.domain.model.DetailCoffeeing
import com.coffeeing.client.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {
    private var _coffeeingDetail = MutableStateFlow<DetailCoffeeing?>(null)
    val coffeeingDetail get() = _coffeeingDetail.asStateFlow()

    fun getCoffeeingDetail(postId: Int) {
        viewModelScope.launch {
            homeRepository.getCoffeeingDetail(postId)
                .onSuccess {
                    _coffeeingDetail.value = it
                }
                .onFailure { exception: Throwable ->
                    Timber.e(exception.message)
                }
        }
    }
}