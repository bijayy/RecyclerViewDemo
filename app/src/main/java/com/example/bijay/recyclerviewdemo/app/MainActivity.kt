package com.example.bijay.recyclerviewdemo.app

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import com.example.bijay.recyclerviewdemo.R
import com.example.bijay.recyclerviewdemo.adapter.MyRecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Method calling recycler view and adding add to it.
        initializeRecyclerView()
    }

    fun initializeRecyclerView() {

        //Calling the custom recycler view adapter i.e. MyRecyclerAdapter
        val recyclerAdapter = MyRecyclerAdapter(this)
        recyclerView.adapter = recyclerAdapter

        //Creating the layout of the data to be displayed in the recycler view i.e. in linear with vertical arrangement
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = linearLayoutManager

        //Setting default animation of items in the recycler view. Note: it's default and it's not required to add.
        recyclerView.itemAnimator = DefaultItemAnimator()
    }
}
