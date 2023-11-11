package com.coffeeing.client.presentation.mypage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coffeeing.client.domain.model.Coffeeing
import com.coffeeing.client.domain.model.CoffeeingMypage
import com.coffeeing.client.domain.model.MyApply
import com.coffeeing.client.domain.model.MyClub
import com.coffeeing.client.domain.model.MyLike
import com.coffeeing.client.domain.repository.MypageRepository
import com.coffeeing.client.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class MypageViewModel @Inject constructor(
    private val mypageRepository: MypageRepository
) : ViewModel() {

    private var _myclubList = MutableStateFlow<List<MyClub>?>(null)
    private var _myapplyList = MutableStateFlow<List<MyApply>?>(null)
    private var _mylikeList = MutableStateFlow<List<MyLike>?>(null)
    val myclubList get() = _myclubList.asStateFlow()
    val myapplyList get() = _myapplyList.asStateFlow()
    val mylikeList get() = _mylikeList.asStateFlow()


    fun getMyclubList() {
        viewModelScope.launch {
            mypageRepository.getMyClub()
                .onSuccess {
                    _myclubList.value = it
                }
                .onFailure { exception : Throwable ->
                    Timber.e(exception.message)
                }
        }
    }

    fun getMyapplyList() {
        viewModelScope.launch {
            mypageRepository.getMyApply()
                .onSuccess {
                    _myapplyList.value = it
                }
                .onFailure { exception : Throwable ->
                    Timber.e(exception.message)
                }
        }
    }

    fun getMylikeList() {
        viewModelScope.launch {
            mypageRepository.getMyLike()
                .onSuccess {
                    _mylikeList.value = it
                }
                .onFailure { exception : Throwable ->
                    Timber.e(exception.message)
                }
        }
    }
}