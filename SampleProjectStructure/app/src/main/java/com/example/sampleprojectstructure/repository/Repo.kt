package com.example.sampleprojectstructure.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import com.example.sampleprojectstructure.model.UserData
import com.example.sampleprojectstructure.model.UserEntity
import com.example.sampleprojectstructure.retrofit.RetrofitApiProvider
import com.example.sampleprojectstructure.room.RoomDbCreater
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

const val TAG = "NetworkRequest"
class Repo(val application: Application) {

    //get database here
    val db = RoomDbCreater().getDb(application)
    val daoUser = db.getUserDao()

    fun getUser() : LiveData<List<UserEntity>> {
        RetrofitApiProvider.apiUser.getUser().enqueue(object : Callback<UserData>{
            override fun onResponse(call: Call<UserData>, response: Response<UserData>) {
                //got the response from
                val list = response.body()
                Log.d(TAG, "onResponse: start")
                if(list!=null){
                    runBlocking {
                        CoroutineScope(Dispatchers.IO).launch {
                            daoUser.delete()

                            for(i in 0..1000){
                                for(i in list){
                                    Log.d(TAG, "onResponse: ${i.id}")
                                    daoUser.insert(UserEntity(0,i.id.toString()))
                                }
                            }

                        }
                    }
                }
                Log.d(TAG, "onResponse: end ")
            }
            override fun onFailure(call: Call<UserData>, t: Throwable) {
                Log.d(TAG, "onFailure: the request failed")
            }

        })
       return daoUser.getUser()
    }

}



