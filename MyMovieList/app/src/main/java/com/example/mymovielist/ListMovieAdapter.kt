package com.example.mymovielist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymovielist.databinding.ItemRowMovieBinding

class ListMovieAdapter(private val listMovie: List<Movie>) : RecyclerView.Adapter<ListMovieAdapter.ListMovieViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListMovieViewHolder(var binding: ItemRowMovieBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMovieViewHolder {
        val binding = ItemRowMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListMovieViewHolder(binding)
    }

    override fun getItemCount(): Int = listMovie.size

    override fun onBindViewHolder(holder: ListMovieViewHolder, position: Int) {
        val (poster, title, year, runtime, certificate, rating, votes, overview) = listMovie[position]
        Glide.with(holder.itemView.context)
            .load(poster)
            .into(holder.binding.ivPoster)
        holder.binding.tvTitle.text = title
        holder.binding.tvYear.text = year
        holder.binding.tvRuntime.text = runtime
        holder.binding.tvCertificate.text = certificate
        holder.binding.rbRating.rating = rating.toFloat() / 2
        holder.binding.tvRating.text = rating
        holder.binding.tvVotes.text = "($votes)"
        holder.binding.tvOverview.text = overview
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listMovie[holder.adapterPosition]) }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Movie)
    }
}