package com.example.sampleprojectstructure.retrofit

import com.example.sampleprojectstructure.interfaces.UserApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val retrofit = Retrofit.Builder()
    .baseUrl("https://jsonplaceholder.typicode.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

class RetrofitApiProvider {
    //create the api for user
    companion object{
        val apiUser : UserApi by lazy {
           retrofit.create(UserApi::class.java)
        }
    }
}