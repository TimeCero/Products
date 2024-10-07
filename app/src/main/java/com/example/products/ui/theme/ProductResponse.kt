package com.example.products.ui.theme


data class ProductResponse(
    val products: List<Product>
)

data class Product(
    val id: Int,
    val title: String,
    val price: Double
)
