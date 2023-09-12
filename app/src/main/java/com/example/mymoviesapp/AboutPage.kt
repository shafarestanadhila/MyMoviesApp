package com.example.mymoviesapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class AboutPage : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val btnHome: Button = findViewById(R.id.btn_home)

        btnHome.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_home -> {
                val moveIntent = Intent(this@AboutPage, MainActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}