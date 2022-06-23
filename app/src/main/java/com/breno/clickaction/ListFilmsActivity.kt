package com.breno.clickaction

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.breno.clickaction.databinding.ActivityListFilmsBinding

class ListFilmsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListFilmsBinding

    private val listFilm: List<FilmModel> by lazy {
        getListFilm()
    }

    private val category: List<CategoryModel> by lazy {
        getListCategory()
    }

    private val categoryAdapter: com.brenol.regular_adapter.RegularAdapter<CategoryModel> by lazy {
        com.brenol.regular_adapter.RegularAdapter.getAdapter(R.layout.item_category, BR.category, category) { _, item ->
            Toast.makeText(this@ListFilmsActivity, item.category, Toast.LENGTH_SHORT).show()
        }
    }

    private val filmAdapter by lazy {
        com.brenol.regular_adapter.RegularAdapter.getAdapter(R.layout.item_film, BR.film, listFilm) { _, item ->
            Toast.makeText(this@ListFilmsActivity, item.title, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = bindingContentView<ActivityListFilmsBinding>(R.layout.activity_list_films).also {
            it.categoryAdapter = categoryAdapter
            it.filmAdapter = filmAdapter
        }

    }


}
