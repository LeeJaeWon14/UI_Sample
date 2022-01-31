package com.example.ui_sample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ui_sample.R

class CoordinatorAdapter(private val itemCount: Int) : RecyclerView.Adapter<CoordinatorAdapter.CoordinatorViewHolder>() {
    class CoordinatorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text: TextView = view.findViewById(R.id.tv_coordinator)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoordinatorViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.coordinator_item, parent, false)
        return CoordinatorViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoordinatorViewHolder, position: Int) {
        holder.text.text = "${position}번째 TextView"
    }

    override fun getItemCount(): Int {
        return itemCount
    }
}