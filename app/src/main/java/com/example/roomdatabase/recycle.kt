package com.example.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class recycle : AppCompatActivity(), OnItemClick {


    //  var dataList = ArrayList<User>()
    //lateinit var recyclerView: RecyclerView
    // lateinit var adapter:Cadapter

    private var adapter: Cadapter? = null

    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle)

        //recyclerView.adapter= Cadapter(dataList,this)
        // recyclerView.layoutManager= LinearLayoutManager(this)

        val photoList = db.getIns(applicationContext)?.Cdao()?.SelectAll()

        recyclerView = findViewById(R.id.recycler_view)

        adapter = Cadapter(this, photoList)
        adapter?.click = this

        val layoutManager = LinearLayoutManager(this)

        this.recyclerView!!.layoutManager = layoutManager

        recyclerView!!.adapter = adapter


    }

    override fun itemClicked(pos: Int) {
        adapter?.notifyDataSetChanged()

   }



    override protected fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
         if(requestCode==100)
         {
             if(requestCode==100)
             {val user=data?.getSerializableExtra("obj")
                 val pos=data?.getIntExtra("pos",0)
                 val id=data?.getIntExtra("id",0)
                 val photoList = db.getIns(applicationContext)?.Cdao()?.SelectAll()

             }

         }

    }

}
