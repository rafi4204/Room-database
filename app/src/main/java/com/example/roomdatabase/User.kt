package com.example.roomdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "user")
class User(
    @ColumnInfo(name = "name") var name: String = "", @ColumnInfo(name = "age") var age: Int, @ColumnInfo(name = "country") var country: String = "", @ColumnInfo(
        name = "city"
    ) var city: String = ""
) : Serializable {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}