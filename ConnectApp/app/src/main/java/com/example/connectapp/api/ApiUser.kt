package com.example.connectapp.api

import com.example.connectapp.model.UserDataResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiUser {
    @GET
    suspend fun getUser() : Call<UserDataResponse>
}