package com.example.mymoviesapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvMovies: RecyclerView
    private val list = ArrayList<Movies>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMovies = findViewById(R.id.rv_movies)
        rvMovies.setHasFixedSize(true)

        list.addAll(getListMovies())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_main -> {
                rvMovies.layoutManager = LinearLayoutManager(this)
            }

            R.id.action_about -> {
                val moveIntent = Intent(this@MainActivity, AboutPage::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListMovies(): ArrayList<Movies> {
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataRelease = resources.getStringArray(R.array.data_release)
        val dataDirector = resources.getStringArray(R.array.data_director)
        val dataProducer = resources.getStringArray(R.array.data_producer)
        val dataLanguage = resources.getStringArray(R.array.data_language)
        val dataWriter = resources.getStringArray(R.array.data_writer)
        val dataBudget = resources.getStringArray(R.array.data_budget)
        val dataMusicDirector = resources.getStringArray(R.array.data_music_director)
        val listMovies = ArrayList<Movies>()
        for (i in dataName.indices) {
            val movies = Movies(
                dataPhoto.getResourceId(i, -1), dataName[i], dataDescription[i], dataRelease[i], dataDirector[i], dataProducer[i], dataLanguage[i], dataWriter[i], dataBudget[i], dataMusicDirector[i])
            listMovies.add(movies)
        }
        return listMovies
    }

    private fun showRecyclerList() {
        rvMovies.layoutManager = LinearLayoutManager(this)
        val listMoviesAdapter = ListMoviesAdapter(list)
        rvMovies.adapter = listMoviesAdapter
    }
}

