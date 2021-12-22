package com.example.connectapp.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.connectapp.api.ApiUser
import com.example.connectapp.model.UserDataResponse
import com.example.connectapp.model.UserDataResponseItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Collections.addAll


class MainViewModel : ViewModel(){



val TAG = "retrofitTest"
   private lateinit var retrofit : Retrofit
   private lateinit var api : ApiUser

     v

    suspend fun getData() {
        retrofit =  Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(ApiUser::class.java)
        api.getUser().enqueue(object : Callback<UserDataResponse>{
            override fun onResponse(
                call: Call<UserDataResponse>,
                response: Response<UserDataResponse>
            ) {
                Log.d(TAG, "onResponse: ${response.body()}")
            }

            override fun onFailure(call: Call<UserDataResponse>, t: Throwable) {
                Log.d(TAG, "onFailure: $t ")
            }

        })

    }


}