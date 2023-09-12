package com.example.mymoviesapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var imgMovies: ImageView
    private lateinit var nameMovies: TextView
    private lateinit var deskripsiMovies: TextView
    private lateinit var releaseMovies: TextView
    private lateinit var directorMovies: TextView
    private lateinit var producerMovies: TextView
    private lateinit var languageMovies: TextView
    private lateinit var writerMovies: TextView
    private lateinit var budgetMovies: TextView
    private lateinit var musicDirectorMovies: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val btnHome: Button = findViewById(R.id.btn_home)
        btnHome.setOnClickListener(this)

        val btnShare: Button = findViewById(R.id.share_action)
        btnShare.setOnClickListener(this)


        imgMovies = findViewById(R.id.iv_movies)
        nameMovies = findViewById(R.id.tv_movies_name)
        deskripsiMovies = findViewById(R.id.tv_movies_description)
        releaseMovies = findViewById(R.id.tv_movies_release)
        directorMovies = findViewById(R.id.tv_director)
        producerMovies = findViewById(R.id.tv_producer)
        languageMovies = findViewById(R.id.tv_language)
        writerMovies = findViewById(R.id.tv_writer)
        budgetMovies = findViewById(R.id.tv_budget)
        musicDirectorMovies = findViewById(R.id.tv_music_director)

        val dataMovies = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Movies>("key_movies", Movies::class.java)
        } else {
            @Suppress("depretion")
            intent.getParcelableExtra<Movies>("key_movies")
        }

        if (dataMovies != null) {
            imgMovies.setImageResource(dataMovies.photo)
            nameMovies.text = dataMovies.name
            deskripsiMovies.text = dataMovies.description
            releaseMovies.text = dataMovies.release
            directorMovies.text = dataMovies.director
            producerMovies.text = dataMovies.producer
            languageMovies.text = dataMovies.language
            writerMovies.text = dataMovies.writer
            musicDirectorMovies.text = dataMovies.musicDirector
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_main -> {
                val moveIntentActivity = Intent(this@DetailActivity, AboutPage::class.java)
                startActivity(moveIntentActivity)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_home -> {
                val moveIntent = Intent(this@DetailActivity, MainActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.share_action -> {
                val text = deskripsiMovies.text
                val share = Intent(Intent.ACTION_SEND)
                share.type = "text/plain"
                share.putExtra(Intent.EXTRA_TEXT, text)
                startActivity(Intent.createChooser(share, "Share Link"))
            }
        }
    }
}
