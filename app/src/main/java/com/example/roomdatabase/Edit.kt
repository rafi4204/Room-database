package com.example.roomdatabase

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
            val age=age.text.toString()
            val country=country.text.toString()





        }

    }
}
