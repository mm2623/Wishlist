package com.example.wishlist

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var lists: kotlin.collections.List<List>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemName = findViewById<View>(R.id.itemName) as EditText
        val price = findViewById<View>(R.id.price) as EditText
        val storeName = findViewById<View>(R.id.storeName) as EditText


        val shopRv = findViewById<RecyclerView>(R.id.shopRv)           //Lookup the RecyclerView in activity layout
        lists = ListFetcher.getList()
        val adapter = ListAdapter(lists as MutableList<List>)                               //Create adapter passing in the list of emails
        shopRv.adapter = adapter                                       //Attach the adapter to the RecyclerView to populate items
        shopRv.layoutManager = LinearLayoutManager(this)        // Set layout manager to position the items

        val button = findViewById<Button>(R.id.btn)
        button.setOnClickListener {
            val itemNameValue = itemName.text.toString()
            val priceValue = price.text.toString()
            val storeNameValue = storeName.text.toString()

            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager //To keep keyboard off when clicked submit.
            inputMethodManager.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)


            val newList = ListFetcher.addLists(itemNameValue,priceValue,storeNameValue)
            (lists as MutableList<List>).addAll(newList)
            adapter.notifyDataSetChanged()
        }

    }
}