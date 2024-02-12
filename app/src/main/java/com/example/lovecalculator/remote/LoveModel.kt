package com.example.lovecalculator.remote

@Entity(tableName = "love_model")
data class LoveModel (
    @SerializedName("fname")
    var firstName: String,
    @SerializedName("sname")
    var secondName:String,
    var percentage: String,
    var result:  String,
    @PrimaryKey(autoGenerate = true)
    var id:Int? = 0
): java.io.Serializable