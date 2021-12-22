package com.example.android.marsphotos.network

import retrofit2.http.*

interface UserApi {
    @POST("posts/{id}/comments")

   suspend fun getComments(
        @Path("id")
        postId:Int,

    ):String

}