package com.coffeeing.client.presentation.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coffeeing.client.data.model.request.RequestWriteCoffeeing
import com.coffeeing.client.domain.model.WriteCoffeeing
import com.coffeeing.client.domain.repository.MainRepository
import com.coffeeing.client.util.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {
    private val _postCoffeeingState = MutableStateFlow<UiState<WriteCoffeeing>>(UiState.Loading)
    val postCoffeeingState get() = _postCoffeeingState.asStateFlow()
    fun postCoffeeing(
        id: Int,
        title: String,
        district: String,
        meetTime: String,
        numPeople: Int,
        date: String,
        tag: String,
        context: String
    ) {
        viewModelScope.launch {
            val parsedDate = LocalDate.parse(date)
            mainRepository.postCoffeeing(
                postId = id,
                RequestWriteCoffeeing(
                    title = title,
                    district = district,
                    meetTime = meetTime,
                    numPeople = numPeople,
                    deadlineYY = parsedDate.year,
                    deadlineMM = parsedDate.monthValue.toString(),
                    deadlineDD = parsedDate.dayOfMonth.toString(),
                    tag = tag,
                    content = context
                )
            ).onSuccess { writeCoffeeing ->
                _postCoffeeingState.value = UiState.Success(writeCoffeeing)
            }.onFailure { throwable ->
                _postCoffeeingState.value = UiState.Error(throwable.message)
            }
        }
    }
}