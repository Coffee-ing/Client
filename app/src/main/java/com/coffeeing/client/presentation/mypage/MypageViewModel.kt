package com.coffeeing.client.presentation.mypage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coffeeing.client.domain.model.Coffeeing
import com.coffeeing.client.domain.model.CoffeeingMypage
import com.coffeeing.client.domain.model.MyClub
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
    val myclubList get() = _myclubList.asStateFlow()

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
}