package com.breno.clickaction

import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

fun <T> AppCompatActivity.bindingContentView(layout: Int): T {
    return DataBindingUtil.setContentView<ViewDataBinding>(this, layout)
        .also { it.lifecycleOwner = this } as T
}

fun getListCategory(): List<CategoryModel> {
    return listOf(
        CategoryModel("Stand Up", 7, R.drawable.ic_comedy),
        CategoryModel("Ação", 15, R.drawable.ic_action),
        CategoryModel("Romance", 18, R.drawable.ic_romance),
        CategoryModel("Comédia", 17, R.drawable.ic_comedy),
        CategoryModel("Drama", 10, R.drawable.ic_drama),
        CategoryModel("Documentário", 12, R.drawable.ic_document),
        CategoryModel("Stand Up", 7, R.drawable.ic_comedy)
    )
}

fun getListFilm(): List<FilmModel> {
    return listOf(
        FilmModel("Os malucos", "Adalberto Sam", "130"),
        FilmModel("Os tiras", "Sam Andreas", "300"),
        FilmModel("Arremessanto alto", "Adam Smith", "200", 4),
        FilmModel("Sem falar dele", "FJdwidh Jwdwwd", "203", 2),
        FilmModel("O amor", "Gilberto Tosch", "110", 1),
        FilmModel("Os arrumados", "Silva Lucas", "90", 3),
        FilmModel("Simbora ", "Amanda Guerero", "100", 5),
        FilmModel("Love Lande", "Ihaa Sentia", "302", 2),
        FilmModel("Ive Fire", "Adalberto Sam", "130", 3),
        FilmModel("Os Cenas em ação", "Smile Turc", "222", 4),
    )
}