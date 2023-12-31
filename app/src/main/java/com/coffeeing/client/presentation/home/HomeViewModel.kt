package com.coffeeing.client.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coffeeing.client.domain.model.HomeCoffeeing
import com.coffeeing.client.domain.model.Like
import com.coffeeing.client.domain.repository.MainRepository
import com.coffeeing.client.presentation.type.HomeSortType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {
    private var _homeSort = MutableLiveData(HomeSortType.RECENT)
    val homeSort get() = _homeSort
    private var _homeList = MutableStateFlow<List<HomeCoffeeing>?>(null)
    val homeList get() = _homeList.asStateFlow()
    private val _likeState = MutableStateFlow<Like?>(null)
    val likeState get() = _likeState.asStateFlow()
    private val _filterType = MutableStateFlow<String?>(null)
    val filterType get() = _filterType.asStateFlow()

    fun setHomeSort(homeSortType: HomeSortType) {
        _homeSort.value = homeSortType
    }

    fun getHomeList() {
        viewModelScope.launch {
            mainRepository.getHomeList()
                .onSuccess {
                    _homeList.value = it
                }
                .onFailure { exception: Throwable ->
                    Timber.e(exception.message)
                }
        }
    }

    fun getSearch(keyword: String) {
        viewModelScope.launch {
            mainRepository.getSearch(keyword)
                .onSuccess {
                    _homeList.value = it
                }
                .onFailure { exception ->
                    Timber.e(exception.message)
                }
        }
    }

    fun getSort(sort: String) {
        viewModelScope.launch {
            mainRepository.getSort(sort)
                .onSuccess {
                    _homeList.value = it
                }
                .onFailure { exception ->
                    Timber.e(exception.message)
                }
        }
    }

    fun getFilter(tag: String) {
        viewModelScope.launch {
            mainRepository.getFilter(tag)
                .onSuccess {
                    _homeList.value = it
                }
                .onFailure { exception ->
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

    fun setFilterType(tag: String) {
        _filterType.value = tag
    }
}