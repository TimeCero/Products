package com.example.products.ui.theme


import retrofit2.http.GET
import retrofit2.Call

interface DummyApiService {
    @GET("products")
    fun getProducts(): Call<ProductResponse>
}
