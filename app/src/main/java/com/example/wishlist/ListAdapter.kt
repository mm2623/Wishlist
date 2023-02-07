package com.example.wishlist

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val lists: MutableList<List>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // TODO: Create member variables for any view that will be set
        val senderTextView: TextView
        val titleTextView: TextView
        val summaryTextView: TextView

        init {
            // TODO: Store each of the layout's views into
            senderTextView = itemView.findViewById(R.id.displayName)
//            senderTextView.paintFlags = senderTextView.paintFlags or Paint.UNDERLINE_TEXT_FLAG
            titleTextView = itemView.findViewById(R.id.displayPrice)
            summaryTextView = itemView.findViewById(R.id.displayUrl)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.list_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return lists.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Get the data model based on position
        val list = lists[position]

        // TO delete an Item
        holder.itemView.setOnLongClickListener {
            Log.v("on click listener","In the system")
            Log.d("postion", position.toString())
            val lists :  MutableList<List> = lists
            lists.removeAt(position)
            notifyItemRemoved(position)
            notifyDataSetChanged()
            true
        }

        //To view the url
        holder.itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(list.description))
            holder.itemView.context.startActivity(intent)
        }

        //Set item views based on views and data model
        holder.senderTextView.text = list.itemName
        holder.titleTextView.text = list.price
        holder.summaryTextView.text = list.description
    }
}

