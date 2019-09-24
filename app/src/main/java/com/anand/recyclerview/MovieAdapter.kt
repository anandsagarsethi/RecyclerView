package com.anand.recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.layout_movie_item.view.*

class MovieAdapter(val context: Context, val list: List<Movie>): RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    //it inflates the layout for each row
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_movie_item, parent, false)
        return ViewHolder(view)
    }

    //it returns the size of the list
    override fun getItemCount(): Int = list.size

    //it binds data to each row, which means this fucntion runs each time for each row
    //here, this function .runs for each row, sop we shouldnt do heavy calculations here as rows may be in large number
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val movie = list[position]

        holder.textViewName.text = movie.title
        holder.textViewYear.text = movie.year.toString()

        if (movie.cast.isNotEmpty()) {
            holder.chipCast.visibility = View.VISIBLE
            holder.chipCast.removeAllViews()
            for (c in movie.cast) {
                val chip = Chip(context)
                chip.text = c
                holder.chipCast.addView(chip)
            }
        } else {
            holder.chipCast.visibility = View.GONE
        }

        if (movie.genres.isNotEmpty()) {
            holder.chipGenre.visibility = View.VISIBLE
            holder.chipGenre.removeAllViews()
            for (c in movie.genres) {
                val chip = Chip(context)
                chip.text = c
                holder.chipGenre.addView(chip)
            }
        } else {
            holder.chipGenre.visibility = View.GONE
        }

        holder.itemView.setOnClickListener {

            val intent = Intent(context, SecondActivity::class.java)
            intent.putExtra("movie", movie)
            context.startActivity(intent)

        }

    }


    //this is used to hold the view objects
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val textViewName =  view.text_view_name
        val textViewYear =  view.text_view_year
        val chipCast =  view.chip_group_cast
        val chipGenre =  view.chip_group_genre

    }

}