package com.example.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.security.AccessControlContext

@Database(entities = arrayOf(User::class),version = 1)
abstract class db : RoomDatabase(){
companion object{
    private var DB:db?=null

    fun getIns(context: Context):db?{
        if(DB==null){
            synchronized(db::class){
                DB=Room.databaseBuilder(context.getApplicationContext(),db::class.java,"UserData.db")
                    .allowMainThreadQueries().build()
            }
        }
        return DB

    }


}

    abstract fun Cdao():cdao
}