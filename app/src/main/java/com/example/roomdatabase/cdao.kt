package com.example.roomdatabase


import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface cdao {
    @Query("SELECT * FROM user")
    fun SelectAll(): MutableList<User>

    @Insert(onConflict = REPLACE)
    fun Insert(user: User)

    @Delete
    fun Delete(user: User)

    @Query("SELECT id FROM user WHERE name=:name")
    fun Find(name: String): Int
}