package com.breno.clickaction

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.annotation.DrawableRes

class CategoryModel(
    val category: String,
    val ageMin: Int,
    @DrawableRes val image: Int
)