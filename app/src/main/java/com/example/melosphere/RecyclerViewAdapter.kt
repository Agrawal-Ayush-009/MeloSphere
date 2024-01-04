package com.example.melosphere

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.RecyclerListener
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.squareup.picasso.Picasso

class RecyclerViewAdapter(private val context: Context, private val listener: HomeFragment):
    RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {

    private val allItems = ArrayList<AlbumRVModal>();

    inner class ItemViewHolder(itemView: View): ViewHolder(itemView) {
        val coverImage = itemView.findViewById<ImageView>(R.id.trending_playlist)
        val playlist_name = itemView.findViewById<TextView>(R.id.trending_name)
        val artistName = itemView.findViewById<TextView>(R.id.trending_artists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.trending_item,parent,false)
        val viewHolder = ItemViewHolder(view)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return allItems.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val albumRVModal = allItems[position]
        Picasso.get().load(albumRVModal.imageUrl).into(holder.coverImage)
        holder.playlist_name.setText(albumRVModal.name).toString()
        holder.artistName.setText(albumRVModal.artistName).toString()
//        holder.itemView.setOnClickListener{
//
//        }
    }
}