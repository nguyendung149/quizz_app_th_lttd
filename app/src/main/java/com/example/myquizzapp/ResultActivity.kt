package com.example.myquizzapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName:TextView= findViewById(R.id.tv_name)
        val tvScore:TextView =findViewById(R.id.tv_score)
        val btnFinish:Button = findViewById(R.id.btn_finish)
        val btnViewRank:Button = findViewById(R.id.btn_viewRank)

        val totalQuestions:Int = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctAnswer:Int = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        tvName.text = intent.getStringExtra(Constants.USER_NAME)
        tvScore.text = "Your Score is $correctAnswer out of $totalQuestions"

        btnFinish.setOnClickListener {
            startActivity(Intent(this@ResultActivity,MainActivity::class.java))
        }
        btnViewRank.setOnClickListener {
            startActivity(Intent(this@ResultActivity,RoundRankActivity::class.java))
        }


    }
}