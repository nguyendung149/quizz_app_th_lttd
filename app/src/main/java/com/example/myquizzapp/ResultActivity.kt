package com.example.myquizzapp

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    lateinit var  fileHelper:FileHelper
    lateinit var mediaPlayer: MediaPlayer

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName: TextView = findViewById(R.id.tv_name)
        val tvScore: TextView = findViewById(R.id.tv_score)
        val btnFinish: Button = findViewById(R.id.btn_finish)
        val btnRanking:Button = findViewById(R.id.btn_ranking)

        val totalQuestions: Int = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswer: Int = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val userName: String = intent.getStringExtra(Constants.USER_NAME).toString()


        fileHelper = FileHelper()
        tvName.text = userName
        tvScore.text = "Your Score is $correctAnswer out of $totalQuestions"

        fileHelper.writeData(this,userName,correctAnswer)


        btnFinish.setOnClickListener {
            startActivity(Intent(this@ResultActivity, MainActivity::class.java))
            finish()
        }
        btnRanking.setOnClickListener {
            var intent = Intent(this@ResultActivity,RankActivity::class.java)
                intent.putExtra(Constants.USER_NAME, userName)
                intent.putExtra(Constants.TOTAL_QUESTIONS, totalQuestions)
                intent.putExtra(Constants.CORRECT_ANSWERS, correctAnswer)
                startActivity(intent)
                finish()
        }
        playBackgroundMusic()
    }
    private fun playBackgroundMusic() {
        // Use the appropriate sound resource ID
        val soundResourceId = R.raw.nhacchucmung

        // Check if the sound resource exists
        if (soundResourceId != 0) {
            mediaPlayer = MediaPlayer.create(this@ResultActivity, soundResourceId)
            mediaPlayer.setOnCompletionListener {
                // Your logic when the music finishes
            }
            mediaPlayer.start()
            mediaPlayer.setVolume(0.5f, 0.5f) // Adjust volume as needed
        }
    }
    override fun onStop() {
        super.onStop()
        stopMusic()
    }
    private fun stopMusic() {
        if (::mediaPlayer.isInitialized) {
            mediaPlayer.stop()
            mediaPlayer.release()
        }
    }
}