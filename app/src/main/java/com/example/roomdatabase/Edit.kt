package com.example.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit.*

class Edit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        btn_save.setOnClickListener {

            val name = name.text.toString()
            val city=city.text.toString()
            val age=age.text.toString().toInt()
            val country=country.text.toString()

           val user=User(name,age,country,city)
            val inten=Intent()
            val id=inten.getIntExtra("id",0)
            val pos=inten.getIntExtra("pos",0)
            val intent = Intent(this,recycle::class.java)
            intent.putExtra("Obj",user)
             intent.putExtra("id",id)
            intent.putExtra("pos",pos)
            setResult(100,intent)

        }

    }
}


