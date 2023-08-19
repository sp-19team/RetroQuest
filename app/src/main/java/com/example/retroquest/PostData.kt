package com.example.retroquest

import java.io.Serializable

data class PostData(
    val title: String,
    val author: String,
    val fullContent: String,
    val date: String,
    val selectedImg: Int
) : Serializable