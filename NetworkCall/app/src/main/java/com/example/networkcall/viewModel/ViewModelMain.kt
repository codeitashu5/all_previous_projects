package com.example.networkcall.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.networkcall.api.ApiUser
import com.example.networkcall.model.ResponseObject
import com.example.networkcall.model.ResponseObjectItem
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class ViewModelMain : ViewModel() {
    //create an live data for the process
    val listUser: MutableLiveData<ArrayList<ResponseObjectItem>> = MutableLiveData()
    val TAG = "errorResponse"
    private lateinit var retrofit: Retrofit

    fun getData(){

        //retrofit object created
        retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api  = retrofit.create(ApiUser::class.java)
        api.getUser().enqueue(object:Callback<ResponseObject>{
            override fun onResponse(
                call: Call<ResponseObject>,
                response: Response<ResponseObject>
            ) {

              val raw =  response.raw()
                Log.d(TAG, "onResponse: ${raw}")
                listUser.value = response.body()
            }

            override fun onFailure(call: Call<ResponseObject>, t: Throwable) {
                Log.d("adb", "onFailure: ${t} ")
            }

        })
    }
}