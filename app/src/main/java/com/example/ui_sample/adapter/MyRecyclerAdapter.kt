package com.example.ui_sample.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.ui_sample.R
import com.example.ui_sample.activity.RecyclerviewActivity
import com.example.ui_sample.databinding.RecyclerItemBinding
import java.util.*

class MyRecyclerAdapter(private val count : Int) : RecyclerView.Adapter<MyRecyclerAdapter.MyRecyclerViewHolder>() {

    class MyRecyclerViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val image = view.findViewById<ImageView>(R.id.iv_rvItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyRecyclerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return MyRecyclerViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return count
    }

    override fun onBindViewHolder(holder: MyRecyclerViewHolder, position: Int) {
        when(Random().nextInt(3)) {
            0 -> { holder.image.setImageResource(R.color.purple_200) }
            1 -> { holder.image.setImageResource(R.color.purple_500) }
            2 -> { holder.image.setImageResource(R.color.purple_700) }
        }

        holder.image.setOnClickListener {
            (holder.itemView.context as RecyclerviewActivity).showInitDialog()
        }
    }
}