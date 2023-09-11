package com.bestswlkh0310.dabaeun.entity

import java.time.LocalDateTime

data class BoardList (
    val title: String,
    val thumbnail: Int,
    val author: String,
    val createdTime: LocalDateTime,
    val authorProfile: Int
)