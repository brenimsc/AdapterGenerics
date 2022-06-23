package com.breno.clickaction

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.breno.clickaction.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val adapter: com.brenol.regular_adapter.RegularAdapter<CategoryModel> by lazy {
        com.brenol.regular_adapter.RegularAdapter.getAdapter(R.layout.item_category, BR.category, category) { _, item ->
            Toast.makeText(this@MainActivity, item.category, Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@MainActivity, ListFilmsActivity::class.java))
        }
    }

    private val category: List<CategoryModel> by lazy {
        getListCategory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = bindingContentView<ActivityMainBinding>(R.layout.activity_main).also {
            it.adapter = adapter
        }


    }
}