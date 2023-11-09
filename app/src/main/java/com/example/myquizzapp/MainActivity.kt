package com.example.myquizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    private lateinit var btnStart: Button
    private lateinit var et_name:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart = findViewById(R.id.btn_start)
        et_name = findViewById(R.id.et_name)

        btnStart.setOnClickListener {
            if (et_name.text.isEmpty()) {
                Toast.makeText(applicationContext, "Please enter your name!", Toast.LENGTH_LONG)
                    .show()
            }else{
                val intent = Intent(this@MainActivity,QuizzQuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME,et_name.text.toString())
                startActivity(intent)
                finish()

            }
        }
    }
}