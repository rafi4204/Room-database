package com.example.roomdatabase

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_edit.*

class Edit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        var model=intent.getSerializableExtra("model") as User
        var id=model.id
        val pos=intent.getIntExtra("pos",0)

        btn_save.setOnClickListener {
            val name = name.text.toString()
            val city=city.text.toString()
            val age=age.text.toString().toInt()
            val country=country.text.toString()
            model=User(name,age,country,city)
            model.id=id
          Log.d("4", "$name $city $country ${age.toString()}")
            val inten=Intent()
            inten.putExtra("Obj",model)
            inten.putExtra("pos",pos)
            setResult(Activity.RESULT_OK,inten)
            finish()

        }

    }
}


