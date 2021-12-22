package com.sumit.userapp.networking

import com.sumit.userapp.database.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.delay

class NetWorkProvider {
    suspend fun getUserList(): ArrayList<User> {
        delay(3000)

        val jsonData =
            "[{\"id\":1,\"name\":\"sumit\"},{\"id\":2,\"name\":\"ajay\"},{\"id\":3,\"name\":\"naveen\"},{\"id\":4,\"name\":\"manish\"},{\"id\":5,\"name\":\"rohit\"},{\"id\":6,\"name\":\"lalit\"},{\"id\":7,\"name\":\"robin\"},{\"id\":8,\"name\":\"mohit\"},{\"id\":9,\"name\":\"sandeep\"},{\"id\":10,\"name\":\"amit\"},{\"id\":11,\"name\":\"kirti\"},{\"id\":12,\"name\":\"komal\"},{\"id\":13,\"name\":\"sonu\"},{\"id\":14,\"name\":\"Amar\"},{\"id\":15,\"name\":\"Raju\"},{\"id\":16,\"name\":\"rohin\"},{\"id\":17,\"name\":\"monika\"},{\"id\":18,\"name\":\"deepak\"},{\"id\":19,\"name\":\"vijay\"},{\"id\":20,\"name\":\"pankaj\"}]"

        val type = object : TypeToken<ArrayList<User>>() {}.type
        return Gson().fromJson(jsonData, type)


    }
}