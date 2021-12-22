package com.example.sampleprojectstructure.interfaces
import androidx.lifecycle.LiveData
import com.example.sampleprojectstructure.model.UserData
import retrofit2.Call
import retrofit2.http.GET

interface UserApi {
    @GET("posts")
     fun getUser() : Call<UserData>
}