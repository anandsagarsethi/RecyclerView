package com.anand.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gson = Gson()
        val res = resources.openRawResource(R.raw.movies).bufferedReader().use { it.readText() }
        val type = object : TypeToken<List<Movie>>() {}.type

        val list = gson.fromJson<List<Movie>>(res, type)

        recyclerView.setHasFixedSize(true)

        val adapter = MovieAdapter(this, list)
        recyclerView.adapter = adapter

    }

}
