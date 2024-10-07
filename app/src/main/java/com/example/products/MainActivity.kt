package com.example.products

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.products.ui.theme.ProductViewModel
import com.example.products.ui.theme.ProductsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductsTheme {
                ProductListScreen()
            }
        }
    }
}

@Composable
fun ProductListScreen(viewModel: ProductViewModel = viewModel()) {
    val products by viewModel.products.collectAsState(initial = emptyList())

    // Llamada a la API al cargar la pantalla
    LaunchedEffect(Unit) {
        viewModel.fetchProducts()
    }

    LazyColumn {
        items(products) { product ->
            Text(text = "${product.title} - ${product.price}$")
        }
    }
}
