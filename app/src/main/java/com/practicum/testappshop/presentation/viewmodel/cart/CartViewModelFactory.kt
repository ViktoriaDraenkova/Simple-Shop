package com.practicum.testappshop.presentation.viewmodel.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.practicum.testappshop.domain.cart.CartInteractor

class CartViewModelFactory(private val cartInteractor: CartInteractor) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CartViewModel(cartInteractor) as T
    }
}