package com.practicum.testappshop.presentation.viewmodel.cart

import androidx.lifecycle.ViewModel
import com.practicum.testappshop.domain.cart.CartInteractor
import com.practicum.testappshop.domain.models.Product

class CartViewModel(private val cartInteractor: CartInteractor) : ViewModel() {

    fun increaseInCart(product: Product): Boolean {
        return cartInteractor.addProductToCart(product)
    }

    fun decreaseInCart(product: Product): Boolean {
        return cartInteractor.deleteProductFromCart(product)
    }

    fun getCart(): List<Pair<Product, Long>> {
        return cartInteractor.getCart().values.toList()
    }
}