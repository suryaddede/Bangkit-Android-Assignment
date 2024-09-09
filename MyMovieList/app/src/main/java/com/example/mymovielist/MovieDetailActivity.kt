package com.example.mymovielist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.mymovielist.databinding.ActivityMovieDetailBinding

class MovieDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movie = intent.getParcelableExtra<Movie>("movie")


        Glide.with(this)
            .load(movie?.poster)
            .into(binding.ivCoverPhoto)
        binding.tvTitle.text = movie?.title
        binding.tvYear.text = movie?.year
        binding.tvRuntime.text = movie?.runtime
        binding.tvCertificate.text = movie?.certificate
        binding.rbRating.rating = movie?.rating?.toFloat()?.div(2) ?: 0f
        binding.tvRating.text = movie?.rating
        binding.tvVotes.text = "(${movie?.votes})"
        Glide.with(this)
            .load(movie?.poster)
            .into(binding.ivPoster)
        binding.tvOverview.text = movie?.overview
        Glide.with(this)
            .load(movie?.castPhoto1)
            .into(binding.ivCastPhoto1)
        binding.tvCastName1.text = movie?.castName1
        binding.tvCastRole1.text = movie?.castRole1
        Glide.with(this)
            .load(movie?.castPhoto2)
            .into(binding.ivCastPhoto2)
        binding.tvCastName2.text = movie?.castName2
        binding.tvCastRole2.text = movie?.castRole2
        Glide.with(this)
            .load(movie?.castPhoto3)
            .into(binding.ivCastPhoto3)
        binding.tvCastName3.text = movie?.castName3
        binding.tvCastRole3.text = movie?.castRole3
        Glide.with(this)
            .load(movie?.castPhoto4)
            .into(binding.ivCastPhoto4)
        binding.tvCastName4.text = movie?.castName4
        binding.tvCastRole4.text = movie?.castRole4
        Glide.with(this)
            .load(movie?.castPhoto5)
            .into(binding.ivCastPhoto5)
        binding.tvCastName5.text = movie?.castName5
        binding.tvCastRole5.text = movie?.castRole5
        binding.backButton.setOnClickListener {
            finish()
        }
        binding.actionShare.setOnClickListener {
            val sendIntent: String = "Movie: ${movie?.title}\n" +
                    "Year: ${movie?.year}\n" +
                    "Runtime: ${movie?.runtime}\n" +
                    "Certificate: ${movie?.certificate}\n" +
                    "Rating: ${movie?.rating}\n" +
                    "Votes: ${movie?.votes}\n" +
                    "Overview: ${movie?.overview}\n" +
                    "Cast: ${movie?.castName1}, ${movie?.castName2}, ${movie?.castName3}, ${movie?.castName4}, ${movie?.castName5}"
            val shareIntent = Intent()
            shareIntent.action = Intent.ACTION_SEND
            shareIntent.putExtra(Intent.EXTRA_TEXT, sendIntent)
            shareIntent.type = "text/plain"
            startActivity(Intent.createChooser(shareIntent, "Share to:"))
        }
    }
}