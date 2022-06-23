package com.breno.clickaction

data class FilmModel(
    val title: String,
    val author: String,
    val duration: String,
    val targetPopularity: Int = 0
) {
    val target: TargetPopularity
        get() = when (targetPopularity) {
        0 -> TargetPopularity.NORMAL
        1 -> TargetPopularity.POPULAR
        2 -> TargetPopularity.START
        else -> TargetPopularity.SUPER_STAR
    }
}