package com.breno.clickaction

import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.brenol.regular_adapter.RegularAdapter

@BindingAdapter("duration")
fun TextView.setDuration(text: String) {
    this.text = "Duração: $text minuto/s"
}

@BindingAdapter("popularity")
fun ImageView.setPopularity(popularity: TargetPopularity) {
    this.setImageDrawable(
        ContextCompat.getDrawable(
            context,
            when (popularity) {
                TargetPopularity.NORMAL -> R.drawable.ic_normal
                TargetPopularity.POPULAR -> R.drawable.ic_popular
                TargetPopularity.START -> R.drawable.ic_star
                TargetPopularity.SUPER_STAR -> R.drawable.ic_superstar
            }
        )
    )
}

@BindingAdapter("drawableImage")
fun ImageView.setDrawableImage(@DrawableRes image: Int) {
    setImageDrawable(ContextCompat.getDrawable(context, image))

}


@BindingAdapter("colorAge")
fun CardView.setColorAge(age: Int) {
    this.setCardBackgroundColor(
        ContextCompat.getColor(
            context,
            when (age) {
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9 -> R.color.green
                10, 11 -> R.color.blue
                12, 13 -> R.color.yellow
                14, 15 -> R.color.orange
                16 -> R.color.red
                else -> R.color.black
            }
        )
    )
}

@BindingAdapter("descriptionAge")
fun TextView.setAge(age: Int) {
    when (age) {
        in 1..9 -> -1
        in 10..11 -> 10
        12,13 -> 12
        14,15 -> 14
        16, 17 -> 16
        else -> 18
    }.takeIf { it != -1 }?.run {
        setTextInternal("+$this")
    } ?: setTextInternal("L")

}

fun TextView.setTextInternal(text: String) {
    this.text = text
}

@BindingAdapter("adapter")
fun <T> RecyclerView.setAdapter(adapter: RegularAdapter<T>) {
    this.adapter = adapter
}