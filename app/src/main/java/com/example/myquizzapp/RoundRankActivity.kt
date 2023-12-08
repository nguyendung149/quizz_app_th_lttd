package com.example.myquizzapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RoundRankActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RoundRankAdapter
    private var fileHelper: FileHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_round_rank)

        var rankList = FileHelper.readData(this@RoundRankActivity)

        recyclerView = findViewById(R.id.recyclerView)
        adapter = RoundRankAdapter(rankList,this) // Khởi tạo adapter sau này
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}