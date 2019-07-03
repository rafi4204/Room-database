package com.example.roomdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val add = findViewById<Button>(R.id.btn_add)
        val show = findViewById<Button>(R.id.btn_show)

        add.setOnClickListener {
           // val age = ag.toInt()
            val name = (findViewById<View>(R.id.name) as TextInputEditText).text.toString()
            val ag = age.text.toString()
            val country = country.text.toString()
            val city = city.text.toString()

             val age=ag.toInt()
            Log.d("2", "name: ${name}  $country")

            val user = User(name, age, country, city)

            db.getIns(applicationContext)?.Cdao()?.Insert(user)
        }
        show.setOnClickListener {


            //Toast.makeText(applicationContext,"name : $name  age:23",Toast.LENGTH_LONG).show()
            // Log.d("2", userInfo?.get(0)?.name + "   " + userInfo?.get(0)?.country + "  " + userInfo?.get(0)?.city)

            val intent = Intent(this, recycle::class.java)
            startActivity(intent)


        }


    }
}
