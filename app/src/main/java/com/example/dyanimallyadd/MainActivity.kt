//package com.example.dyanimallyadd
//
//import android.content.Context
//import android.content.SharedPreferences
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.view.View
//import android.widget.Button
//import android.widget.TextView
//import android.widget.Toast
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import kotlin.random.Random
//
//class MainActivity : AppCompatActivity() {
//    lateinit var adapter: Adapters
//    lateinit var linearLayoutManager: LinearLayoutManager
//    lateinit var newArrayList: ArrayList<Name>
//    lateinit var recyclerView: RecyclerView
//    lateinit var name: Array<String>
//    lateinit var surname: Array<String>
//    lateinit var TextView:TextView
//    lateinit var button: Button
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        name = arrayOf(
//            "Bilkis",
//        )
//        surname = arrayOf(
//            "Shaikh",
//        )
//        recyclerView = findViewById(R.id.recyclerView)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        newArrayList = arrayListOf<Name>()
//        adapter = Adapters(newArrayList, this)
//        recyclerView.adapter = Adapters(newArrayList, this)
//        getdata()
//    }
// private fun getdata() {
//        for (i in name.indices) {
//            val news = Name(name[i], surname[i],false,"")
//            newArrayList.add(news)
//        }
//}
//    fun add(view: View) {
//        try
//        {
//            Log.i("OnClick", "add: called")
//            val newitem = Name(
//                "Bilkis ${newArrayList.size + 1}",
//                "Shaikh ",false,""
//            )
//            newArrayList.add(newitem)
//            adapter.notifyItemInserted(newArrayList.size - 1)
//            recyclerView.scrollToPosition(newArrayList.size - 1)
//        }
//        catch (e: Exception) {
//            Log.e("Exception", "add: ${e.stackTraceToString()} ")
//        }
//    }
//}