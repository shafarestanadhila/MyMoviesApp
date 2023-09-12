package com.example.mymoviesapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ListMoviesAdapter(private val listMovies: ArrayList<Movies>) : RecyclerView.Adapter<ListMoviesAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_movies, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMovies.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (photo, name, description) = listMovies[position]
        holder.imgItemPhoto.setImageResource(photo)
        holder.tvItemName.text = name
        holder.tvItemDescription.text = description
        holder.itemView.setOnClickListener {
            val intentDetailMovies = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetailMovies.putExtra("key_movies", listMovies[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetailMovies)
        }
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgItemPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvItemName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvItemDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }

}