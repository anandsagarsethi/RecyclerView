package com.anand.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val movie = intent.getParcelableExtra<Movie>("movie")!!

        text_view_name.text = movie.title
        text_view_year.text = movie.year.toString()

        if (movie.genres.isNotEmpty()) {
            for (c in movie.genres) {
                val chip = Chip(this)
                chip.text = c
                chip_group_genre.addView(chip)
            }
        }

        if (movie.cast.isNotEmpty()) {
            for (c in movie.cast) {
                val chip = Chip(this)
                chip.text = c
                chip_group_cast.addView(chip)
            }
        }

    }
}
