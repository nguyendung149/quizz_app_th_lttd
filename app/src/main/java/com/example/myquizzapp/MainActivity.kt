package com.example.myquizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatEditText
import java.util.Locale

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    private lateinit var btnStart: Button
    private lateinit var et_name:EditText
    private lateinit var btnRule:Button
    private lateinit var tts:TextToSpeech
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart = findViewById(R.id.btn_start)
        et_name = findViewById(R.id.et_name)
        btnRule = findViewById(R.id.btn_rule)

        tts = TextToSpeech(this,this)
        btnRule.setOnClickListener {
            var alert = AlertDialog.Builder(this)
            alert.setTitle("How to play")
            alert.setMessage("\"There will be a series of questions about national flags of countries. Your task is to answer as many questions correctly as possible. There will be 3 assists to help you overcome the challenge easily. Good luck!!")
            alert.setCancelable(true)
            alert.create().show()

            speakOut("\"There will be a series of questions about national flags of countries. Your task is to answer as many questions correctly as possible. There will be 3 assists to help you overcome the challenge easily. Good luck!!")

        }
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

    override fun onInit(status: Int) {
        if(status==TextToSpeech.SUCCESS){
            var result = tts.setLanguage(Locale.ENGLISH)
            if(result==TextToSpeech.LANG_MISSING_DATA||result == TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("TTS","Initiazation Failed!")
            }
        }
    }
    private fun speakOut(text:String){
        tts.speak(text,TextToSpeech.QUEUE_FLUSH,null,"")
    }


    override fun onDestroy() {
        super.onDestroy()
        if(tts!=null){
            tts.stop()
            tts.shutdown()
        }
    }
}