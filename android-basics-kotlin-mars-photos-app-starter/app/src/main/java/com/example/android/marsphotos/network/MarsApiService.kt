package com.example.android.marsphotos.network

import com.example.android.marsphotos.util.BASE_URL_APP
import com.google.gson.Gson
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


//we have created the file inside the network package and added the base URL in it
private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

//creating the retrofit builder object which will be used to create api and add converter factory to the

val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

//creating an interface that we will use to define the HTTP request and later used by retrofit to crate an api
interface MarsApiService{
    //inside it i will crate the HTTP request for the phone to communicate web services
    @GET("photos")
     fun getPhotos(): Call<List<MarsPhoto>>
}

//create the api and expose it to the rest of the app
object MarsApi{
    /*val userApi : UserApi by lazy {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(ScalarsConverterFactory.create())
            .baseUrl(BASE_URL_APP)
            .build()
        retrofit.create(UserApi::class.java)
    }*/
    val retrofitService : MarsApiService by lazy {
        //we have created the api and exposed to the app and it can be access using the object MarsApi
        retrofit.create(MarsApiService::class.java)
    }
}