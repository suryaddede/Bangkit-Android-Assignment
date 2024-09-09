package com.example.mymovielist

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val poster: String,
    val title: String,
    val year: String,
    val runtime: String,
    val certificate: String,
    val rating: String,
    val votes: String,
    val overview: String,
    val castPhoto1: String,
    val castName1: String,
    val castRole1: String,
    val castPhoto2: String,
    val castName2: String,
    val castRole2: String,
    val castPhoto3: String,
    val castName3: String,
    val castRole3: String,
    val castPhoto4: String,
    val castName4: String,
    val castRole4: String,
    val castPhoto5: String,
    val castName5: String,
    val castRole5: String,
) : Parcelable
