package com.example.myquizzapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.BufferedWriter
import java.io.File
import java.io.OutputStreamWriter

class RankActivity : AppCompatActivity() {
    lateinit var btnPlayAgain:Button
    private lateinit var tvNoAvalable:TextView
    private lateinit var adapter: RankAdapter
    private lateinit var tvStatus:TextView
    private lateinit var rcView:RecyclerView
    private lateinit var btnClear:Button
    lateinit var  fileHelper :FileHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rank)
        fileHelper = FileHelper()
        val totalQuestions: Int = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswer: Int = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        val userName: String = intent.getStringExtra(Constants.USER_NAME).toString()



        var rankList = fileHelper.readData(this)
        rankList.sortByDescending {
            it.trim().split(",")[1]
        }
        Toast.makeText(this,rankList[0],Toast.LENGTH_LONG).show()
        for(i in 0..<rankList.size){
            rankList[i] = rankList.get(i).trim().trim('\n')
        }
        tvNoAvalable = findViewById(R.id.tvNoRecordsAvailable)
        btnPlayAgain = findViewById(R.id.btnPlayAgain)
        rcView = findViewById(R.id.rvItemList)
        tvStatus = findViewById(R.id.tvNoRecordsAvailable)
        btnClear = findViewById(R.id.btnClearRank)

        rcView.layoutManager = LinearLayoutManager(this)
        adapter = RankAdapter(rankList,this)
        rcView.adapter = adapter

        tvNoAvalable.visibility = View.GONE
        btnClear.setOnClickListener {
            val file = this.openFileOutput("ranking.txt",Context.MODE_PRIVATE)
            var writer = BufferedWriter(OutputStreamWriter(file))
            writer.write("")
            rcView.layoutManager = LinearLayoutManager(this)
            adapter = RankAdapter(fileHelper.readData(this),this)
            rcView.adapter = adapter
            tvNoAvalable.visibility = View.VISIBLE


        }
        btnPlayAgain.setOnClickListener {
            var intent:Intent = Intent(this@RankActivity,MainActivity::class.java)
            startActivity(intent)
        }

    }
}
