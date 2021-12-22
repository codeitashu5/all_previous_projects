package com.example.apicalling

data class Response(
    val `data`: List<Data>,
    val responseCode: ResponseCode
)