package com.example.androidnavigation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cat_item.view.*

class CatListAdapter(val deleteEvent: (String) -> Unit) : RecyclerView.Adapter<CatListAdapter.CatViewHolder>() {

    private val catsList = ArrayList<String>()

    fun setItems(cats: List<String>) {
        catsList.clear()
        catsList.addAll(cats)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        return CatViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.cat_item, parent, false),
            deleteEvent = deleteEvent
        )
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bindItem(catsList[position])
    }

    override fun getItemCount() = catsList.size

    inner class CatViewHolder(itemView: View,val deleteEvent: (String) -> Unit) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(catName: String) {
            itemView.cat_item.text = catName
            itemView.cat_item_delete.setOnClickListener {
                deleteEvent(catName)
            }
        }
    }
}