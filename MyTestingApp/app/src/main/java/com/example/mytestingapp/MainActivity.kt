package com.example.mytestingapp

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnSetValue: Button
    private lateinit var tvText: TextView

    private var names = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSetValue = findViewById(R.id.btn_set_value)
        tvText = findViewById(R.id.tv_text)
        btnSetValue.setOnClickListener() {
            if (it?.id == R.id.btn_set_value) {
                Log.d("MainActivity", names.toString())
                val name = StringBuilder()
                for (i in 0..2) {
                    name.append(names[]).append("\n")
                }
                tvText.text = name.toString()
            }
        }
        names.add("Narendra Wicaksono")
        names.add("Kevin")
        names.add("Yaza")
    }
}