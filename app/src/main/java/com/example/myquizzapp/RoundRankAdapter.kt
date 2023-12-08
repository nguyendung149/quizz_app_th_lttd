package com.example.myquizzapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RoundRankAdapter constructor(
    private var rankList: ArrayList<RankItem>,
    private var context: Context
) : RecyclerView.Adapter<RoundRankAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_round_rank, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = rankList[position]

        // Gán dữ liệu từ RankItem cho các TextView trong ViewHolder
        holder.textView9.text = currentItem.name
        holder.textView7.text = currentItem.score.toString()
    }

    override fun getItemCount(): Int {
        return rankList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textView9: TextView = itemView.findViewById(R.id.textViewUserName)
        val textView7: TextView = itemView.findViewById(R.id.textViewScore)
    }
}
