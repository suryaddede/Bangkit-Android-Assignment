package com.example.mymovielist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mymovielist.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivProfilePhoto.setImageResource(R.drawable.my_photo)
        binding.tvName.text = getString(R.string.name)
        binding.tvEmail.text = getString(R.string.email)
        binding.backButton.setOnClickListener {
            finish()
        }
    }
}