package com.example.lovecalculator.Room

import com.example.lovecalculator.remote.LoveModel

@androidx.room.Dao
interface Dao {
    @Insert

    fun insert(loveModel: LoveModel)


    @Query("SELECT * FROM  love_model")
    fun getAll():List<LoveModel>

    @Query("SELECT * FROM  love_model ORDER BY firstName ASC")
    fun getAllData():List<LoveModel>
}