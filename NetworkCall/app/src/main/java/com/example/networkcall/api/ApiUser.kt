package com.example.networkcall.api

import com.example.networkcall.model.ResponseObject
import retrofit2.Call
import retrofit2.http.GET

interface ApiUser {
    @GET("users")
    fun getUser() : Call<ResponseObject>
}