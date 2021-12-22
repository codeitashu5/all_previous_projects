/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.marsphotos.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.marsphotos.network.MarsApi
import com.example.android.marsphotos.network.MarsPhoto
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log

/**
 * The [ViewModel] that is attached to the [OverviewFragment].
 */
class OverviewViewModel : ViewModel() {

    val TAG ="testCoroutine"
    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status
    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getMarsPhotos()
    }

    /**
     * Gets Mars photos information from the Mars API Retrofit service and updates the
     * [MarsPhoto] [List] [LiveData].
     */
   /*
   private fun test(){
        Thread.sleep(2000)
    }
    */

    //you can call normal function inside the co-routine scope and suspend function
    //but an suspend function can only be called inside an suspend function
    private fun getMarsPhotos() {
        Log.d("marsResponse", "getMarsPhotos out: ${ Thread.currentThread().id}")

        viewModelScope.launch(){
           /* Log.d(TAG, "getMarsPhotos: test call ")
            test()
            Log.d(TAG, "getMarsPhotos: test end")*
            */
            //val r = MarsApi.userApi.getComments(4)
            //Log.d("TAG", "getMarsPhotos: $r")
            //we call our network request here

            Log.d("marsResponse", "getMarsPhotos in: ${ Thread.currentThread().id}")
            try{

                //has it advantages and dis-advantages at the same time we get lot of info about the response in detail
                //error handling is inbuilt
                //hectic to create and make network calls

                MarsApi.retrofitService.getPhotos().enqueue(object : Callback<List<MarsPhoto>>{
                    override fun onResponse(
                        call: Call<List<MarsPhoto>>,
                        response: Response<List<MarsPhoto>>
                    ) {
                        _status.value = "The List has ${response.body()?.size} mars photos"
                    }
                    override fun onFailure(call: Call<List<MarsPhoto>>, t: Throwable) {
                        _status.value = "some error occured"
                    }
                })

            }
            catch (e:Exception){
                Log.d("marsResponse", "getMarsPhotos: ")

            }
        }
    }
}
