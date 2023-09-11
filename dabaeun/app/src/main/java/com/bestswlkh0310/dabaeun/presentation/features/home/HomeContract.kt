package com.bestswlkh0310.dabaeun.presentation.features.home

sealed class HomeCategory(val title: String) {
    object All: HomeCategory(title = "전체")
    object Coding: HomeCategory(title = "코딩")
    object Algorithm: HomeCategory(title = "알고리즘")
    object Exercise: HomeCategory(title = "운동")
}

data class HomeState(
    val isLoading: Boolean = false,
    val selectedCategory: HomeCategory = HomeCategory.All,
    val isBoardRefresh: Boolean = false
)

sealed class HomeSideEffect {
    data class ToastMsg(val msg: String): HomeSideEffect()
}