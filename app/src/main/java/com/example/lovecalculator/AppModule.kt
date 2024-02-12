package com.example.lovecalculator

import android.content.Context
import com.example.lovecalculator.Pref.Pref
import com.example.lovecalculator.remote.LoveApi

class AppModule {
    @Provides
    fun provideApi(): LoveApi {
        return  Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/").addConverterFactory(
            GsonConverterFactory.create()).build().create(LoveApi::class.java)

    }
    @Singleton
    @Provides
    fun providePreferences(@ApplicationContext context: Context): Pref {
        return Pref(context)
    }
}