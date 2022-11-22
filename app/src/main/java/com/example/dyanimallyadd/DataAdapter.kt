package com.example.dyanimallyadd

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(private val userlist: ArrayList<LoginDataclass>) :
    RecyclerView.Adapter<DataAdapter.Viewholder>() {
    class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val emails: TextView = itemView.findViewById(R.id.textView10)
        val pass: TextView = itemView.findViewById(R.id.textView6)
        val nameed: TextView = itemView.findViewById(R.id.textView5)
        val age: TextView = itemView.findViewById(R.id.textView11)
        val dat: TextView = itemView.findViewById(R.id.textView12)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
       val itemView=LayoutInflater.from(parent.context).inflate(R.layout.activity_showalldata,parent,false)
        return  Viewholder(itemView)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
       val currentitem=userlist[position]
        holder.emails.text=currentitem.email
        holder.pass.text=currentitem.password
        holder.nameed.text=currentitem.name
        holder.age.text=currentitem.age.toString()
        holder.dat.text=currentitem.date.toString()
    }

    override fun getItemCount(): Int {
        return userlist.size
    }
}