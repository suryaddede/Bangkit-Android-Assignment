package com.example.myviewmodel

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.myviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //    private lateinit var viewModel: MainViewModel
    private val viewModel: Lazy<MainViewModel> by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        displayResult()
    }

    private fun displayResult() {
        binding.tvResult.text = viewModel.value.result.toString()
    }
}