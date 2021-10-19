package com.skatincorp.le

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val dataSet: Array<Item>, private val onclick:(Item) -> Unit): RecyclerView.Adapter<ListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = dataSet[position]
        holder.textView.text = item.name
        holder.itemView.setOnClickListener { onclick.invoke(item) }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}

class ListViewHolder(view:View): RecyclerView.ViewHolder(view)  {
    val textView: TextView

    init {
        textView = view.findViewById(R.id.texview1)
    }

}