package com.example.lovecalculator.repository

import androidx.lifecycle.MutableLiveData
import com.example.lovecalculator.remote.LoveApi
import com.example.lovecalculator.remote.LoveModel

class Repository  @Inject constructor(val api: LoveApi){
    fun getLove(firstname: String, secondName: String): MutableLiveData<LoveModel> {
        val liveLoveData = MutableLiveData<LoveModel>()
        api.calculatePercentage(firstname, secondName).enqueue(object :Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful){
                    liveLoveData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {

            }

        })
        return liveLoveData
    }


}