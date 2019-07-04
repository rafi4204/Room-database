package com.example.roomdatabase

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

import android.widget.TextView
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.view.*

class Cadapter(private val activity: Activity, private val dataList: MutableList<User>?) :
    RecyclerView.Adapter<Cadapter.CustomViewHolder>() {
    var click : OnItemClick?=null

    inner class CustomViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var name: TextView
        var age: TextView
        var country: TextView
        var city: TextView
        var edit: Button
        var delete: Button

        init {
            name = mView.findViewById(R.id.name)
            age = mView.findViewById(R.id.age)
            country = mView.findViewById(R.id.country)
            city = mView.findViewById(R.id.city)
            edit = mView.findViewById(R.id.edit)
            delete = mView.findViewById(R.id.delete)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.list_item_home, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.name.text = dataList?.get(position)?.name
        holder.age.text = dataList?.get(position)!!.age.toString()
        holder.country.text = dataList[position].country
        holder.city.text = dataList[position].city

        holder.delete.setOnClickListener {

            db.getIns(holder.itemView.context)?.Cdao()?.Delete(dataList[position])
            dataList.removeAt(position)
            //notifyDataSetChanged()
            click?.itemClicked(position)
        }

        holder.edit.setOnClickListener {



           val intent = Intent(holder.itemView.context, Edit::class.java)
          // holder.itemView.context.startActivityForResult<>
            val id=db.getIns(holder.itemView.context)?.Cdao()?.Find(dataList[position].name)
            intent.putExtra("id",id)
            intent.putExtra("pos",position)
            activity.startActivityForResult( intent,100)
        }
    }

    override fun getItemCount(): Int {
        return dataList!!.size
    }
}