package com.example.products.ui.theme

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class Product(val title: String, val price: Double)

class ProductViewModel : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products.asStateFlow()

    fun fetchProducts() {
        viewModelScope.launch {
            // Simular la obtención de productos de una API
            // Aquí puedes hacer la llamada a la API usando Retrofit, por ejemplo
            _products.value = listOf(
                Product("Producto 1", 10.99),
                Product("Producto 2", 5.49)
            )
        }
    }
}
