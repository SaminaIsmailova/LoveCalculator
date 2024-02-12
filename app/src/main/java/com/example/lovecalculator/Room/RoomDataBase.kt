package com.example.lovecalculator.Room

import com.example.lovecalculator.remote.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract  class RoomDataBase: RoomDatabase() {
    abstract fun loveDao():Dao
}