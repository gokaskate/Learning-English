package com.skatincorp.le

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item(
    val name: String,
    @DrawableRes val img: Int
):Parcelable
