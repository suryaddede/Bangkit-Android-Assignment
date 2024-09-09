package com.example.mymovielist

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mymovielist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var rvMovies: RecyclerView
    private val list = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        rvMovies = findViewById(R.id.rv_movies)
        rvMovies.setHasFixedSize(true)

        list.addAll(getListMovies())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.about_page) {
            val intent = Intent(this@MainActivity, AboutActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListMovies(): ArrayList<Movie> {
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataYear = resources.getStringArray(R.array.data_year)
        val dataRuntime = resources.getStringArray(R.array.data_runtime)
        val dataCertificate = resources.getStringArray(R.array.data_certificate)
        val dataRating = resources.getStringArray(R.array.data_rating)
        val dataVotes = resources.getStringArray(R.array.data_votes)
        val dataOverview = resources.getStringArray(R.array.data_overview)
        val dataPoster = resources.getStringArray(R.array.data_poster)
        val dataCastPhoto1 = resources.getStringArray(R.array.data_cast_photo1)
        val dataCastName1 = resources.getStringArray(R.array.data_cast_name1)
        val dataCastRole1 = resources.getStringArray(R.array.data_cast_role1)
        val dataCastPhoto2 = resources.getStringArray(R.array.data_cast_photo2)
        val dataCastName2 = resources.getStringArray(R.array.data_cast_name2)
        val dataCastRole2 = resources.getStringArray(R.array.data_cast_role2)
        val dataCastPhoto3 = resources.getStringArray(R.array.data_cast_photo3)
        val dataCastName3 = resources.getStringArray(R.array.data_cast_name3)
        val dataCastRole3 = resources.getStringArray(R.array.data_cast_role3)
        val dataCastPhoto4 = resources.getStringArray(R.array.data_cast_photo4)
        val dataCastName4 = resources.getStringArray(R.array.data_cast_name4)
        val dataCastRole4 = resources.getStringArray(R.array.data_cast_role4)
        val dataCastPhoto5 = resources.getStringArray(R.array.data_cast_photo5)
        val dataCastName5 = resources.getStringArray(R.array.data_cast_name5)
        val dataCastRole5 = resources.getStringArray(R.array.data_cast_role5)

        val listMovie = ArrayList<Movie>()
        for (position in dataTitle.indices) {
            val movie = Movie(
                dataPoster[position],
                dataTitle[position],
                dataYear[position],
                dataRuntime[position],
                dataCertificate[position],
                dataRating[position],
                dataVotes[position],
                dataOverview[position],
                dataCastPhoto1[position],
                dataCastName1[position],
                dataCastRole1[position],
                dataCastPhoto2[position],
                dataCastName2[position],
                dataCastRole2[position],
                dataCastPhoto3[position],
                dataCastName3[position],
                dataCastRole3[position],
                dataCastPhoto4[position],
                dataCastName4[position],
                dataCastRole4[position],
                dataCastPhoto5[position],
                dataCastName5[position],
                dataCastRole5[position]
            )
            listMovie.add(movie)
        }
        return listMovie
    }

    private fun showRecyclerList() {
        rvMovies.layoutManager = LinearLayoutManager(this)
        val listMovieAdapter = ListMovieAdapter(list)
        rvMovies.adapter = listMovieAdapter

        listMovieAdapter.setOnItemClickCallback(object : ListMovieAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Movie) {
                val intent = Intent(this@MainActivity, MovieDetailActivity::class.java)
                intent.putExtra("movie", data)
                startActivity(intent)
            }
        })
    }
}