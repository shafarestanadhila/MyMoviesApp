package com.example.mymoviesapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movies(
    val photo: Int,
    val name: String,
    val description: String,
    val release: String,
    val director: String,
    val producer: String,
    val language: String,
    val writer: String,
    val budget: String,
    val musicDirector: String
) : Parcelable
