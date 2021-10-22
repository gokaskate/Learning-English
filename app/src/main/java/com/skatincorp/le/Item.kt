package com.skatincorp.le

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Item(
    val name: String,
    @DrawableRes val img: Int,
    @RawRes val file: Int
):Parcelable
