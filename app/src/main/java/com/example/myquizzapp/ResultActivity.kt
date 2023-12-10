package com.example.myquizzapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvName: TextView = findViewById(R.id.tv_name)
        val tvScore: TextView = findViewById(R.id.tv_score)
        val btnFinish: Button = findViewById(R.id.btn_finish)


        val totalQuestions: Int = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswer: Int = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val userName: String = intent.getStringExtra(Constants.USER_NAME).toString()

        val sharedPreferences = getSharedPreferences("leaderboard", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        // Đọc danh sách từ SharedPreferences
        val leaderboardSet = sharedPreferences.getStringSet("leaderboard", mutableSetOf()) ?: mutableSetOf()

        // Thêm kết quả mới vào danh sách
        val newResult = "$userName,$correctAnswer"
        leaderboardSet.add(newResult)

        // Lưu lại danh sách vào SharedPreferences
        editor.putStringSet("leaderboard", leaderboardSet).apply()

        tvName.text = userName
        tvScore.text = "Your Score is $correctAnswer out of $totalQuestions"

        btnFinish.setOnClickListener {
            startActivity(Intent(this@ResultActivity, MainActivity::class.java))
        }
    }
}
