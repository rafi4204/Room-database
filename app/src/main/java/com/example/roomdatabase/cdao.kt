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

   @Update
   fun update(user: User)



}