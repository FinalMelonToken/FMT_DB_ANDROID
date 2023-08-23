package com.bestswlkh0310.dabaeun.data.model

import java.time.LocalDateTime

data class BoardList (
    val title: String,
    val thumbnail: Int,
    val author: String,
    val createdTime: LocalDateTime,
    val authorProfile: Int
)