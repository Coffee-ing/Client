package com.coffeeing.client.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coffeeing.client.domain.model.Coffeeing
import com.coffeeing.client.presentation.type.HomeSortType

class HomeViewModel : ViewModel() {
    private var _homeSort = MutableLiveData(HomeSortType.RECENT)
    val homeSort get() = _homeSort

    val mockHomeCoffeeingList = listOf<Coffeeing>(
        Coffeeing(
            coffeeingId = 1,
            coffeeingImg = "https://github.com/Coffee-ing/Client/assets/103172971/2b1b5ca3-0fda-47e2-a05d-3e800dfc5691",
            title = "용산카페 전문바리스타 커피 클래스",
            location = "서울특별시 용산구",
            time = "매주 토요일 13시",
            person = 10,
            isHearted = false,
            heartCount = 40,
            isBaristaOriginal = true,
            isLocalArea = true,
            isHotPlace = false,
            isProfessional = false,
            isBiginner = true
        ),
        Coffeeing(
            coffeeingId = 2,
            coffeeingImg = "https://github.com/Coffee-ing/Client/assets/103172971/5edd0aa0-a939-4556-8cca-a078a85539f7",
            title = "연남동 카페투어",
            location = "서울특별시 마포구",
            time = "매주 토요일 14시",
            person = 4,
            isHearted = true,
            heartCount = 52,
            isBaristaOriginal = false,
            isLocalArea = true,
            isHotPlace = true,
            isProfessional = false,
            isBiginner = true
        ),
        Coffeeing(
            coffeeingId = 3,
            coffeeingImg = "https://github.com/Coffee-ing/Client/assets/103172971/5edd0aa0-a939-4556-8cca-a078a85539f7",
            title = "신촌 대학생 커핑동호회",
            location = "서울특별시 서대문구",
            time = "매주 토요일 13시",
            person = 6,
            isHearted = false,
            heartCount = 18,
            isBaristaOriginal = false,
            isLocalArea = true,
            isHotPlace = false,
            isProfessional = false,
            isBiginner = true
        )
    )

    fun setHomeSort(homeSortType: HomeSortType) {
        _homeSort.value = homeSortType
    }
}