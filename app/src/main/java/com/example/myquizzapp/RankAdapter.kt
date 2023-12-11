package com.example.myquizzapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class RankAdapter(
    var rankList: ArrayList<String>,
    var context: Context):RecyclerView.Adapter<RankAdapter.RankViewHolder>() {


    class RankViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var tvName:TextView = itemView.findViewById(R.id.tvName)
        var tvScore:TextView = itemView.findViewById(R.id.tvScore)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankViewHolder {
        val view:View = LayoutInflater.from(context).inflate(R.layout.item_rows,parent,false)
        return RankViewHolder(view)
    }

    override fun getItemCount(): Int {
        return rankList.size
    }

    override fun onBindViewHolder(holder: RankViewHolder, position: Int) {
        holder.tvName.text = rankList[position].split(",")[0]
        holder.tvScore.text = rankList[position].split(",")[1]
    }
}