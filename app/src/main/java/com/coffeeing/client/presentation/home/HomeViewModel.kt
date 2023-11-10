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
            isBeginner = true,
            closingDate = "2023-11-10",
            context = "안녕하세요 용산커피대장입니다. 엄마만 손을 2024년 그 운동과 이것이, 도통하여요. 2022년 없다 것 날 부상당하다 결국은 태도가 중 갈아입는 미덕이, 보급되다. 되는 상하의 체중을 방문이게 아니라 거듭 전체로 직업병은 86개 정복하다. 거절한 희생을 거 일어나는 시도한 이제에 사람에 지불되다. 아니 듣은, 그, 작품은 함께 말은 텃밭은 열심히 있으니까 가계성을 생기어.",
            writer = Coffeeing.Writer(nickname = "용산커피대장", numberOfRecruit = 6)
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
            isBeginner = true,
            closingDate = "2023-11-16",
            context = "안녕하세요",
            writer = Coffeeing.Writer(nickname = "연남동", numberOfRecruit = 1)
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
            isBeginner = true,
            closingDate = "2023-11-17",
            context = "ㅋㅋ",
            writer = Coffeeing.Writer(nickname = "신촌대장", numberOfRecruit = 3)
        )
    )

    fun setHomeSort(homeSortType: HomeSortType) {
        _homeSort.value = homeSortType
    }
}