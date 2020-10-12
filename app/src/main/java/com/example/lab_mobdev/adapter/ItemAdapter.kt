package com.example.lab_mobdev.adapter

import android.content.ClipData
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_mobdev.ContainsItem
import com.example.lab_mobdev.R
import com.example.lab_mobdev.model.Item
import kotlinx.android.synthetic.main.recycler_item.view.*

class ItemAdapter (val items : ArrayList<Item>, val context: Context, val caller: ContainsItem) :
    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.amount?.text = items[position].title.toString()
        holder.desc?.text = items[position].desc
        holder.item.setOnClickListener{
            caller.itemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val amount = view.title
    val desc = view.description
    val item = view.item
}