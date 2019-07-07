package com.example.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class recycle : AppCompatActivity(), OnItemClick {


    //  var dataList = ArrayList<User>()
    //lateinit var recyclerView: RecyclerView
    // lateinit var adapter:Cadapter
    lateinit var photoList :MutableList<User>

    private var adapter: Cadapter? = null

    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle)

        //recyclerView.adapter= Cadapter(dataList,this)
        // recyclerView.layoutManager= LinearLayoutManager(this)

         photoList = db.getIns(applicationContext)?.Cdao()?.SelectAll()!!

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


    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        Log.d("3", "recycle")
        if (requestCode == 100) {

            val user = data?.getSerializableExtra("Obj") as User
            val pos = data.getIntExtra("pos", 0)
            //  val id = data?.getIntExtra("id", 0)

            Log.d("3", user.name + "  " + "${user.age}" + " " + user.city + " " + user.country)

            adapter?.dataList?.set(pos, user)
            db.getIns(applicationContext)?.Cdao()?.update(user)
            //val photoList = db.getIns(applicationContext)?.Cdao()?.SelectAll()

           // Log.d("3", photoList?.get(pos)?.name)
            adapter?.notifyDataSetChanged()



            Log.d("3", user.name + "  " + "${user.age}" + " " + user.city + " " + user.country)


        }

    }

}
