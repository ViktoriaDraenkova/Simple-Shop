package com.practicum.testappshop.presentation.viewmodel.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.practicum.testappshop.domain.cart.CartInteractor
import com.practicum.testappshop.domain.models.Product
import com.practicum.testappshop.domain.products.ProductsInteractor
import com.practicum.testappshop.presentation.states.ProductsScreenState
import com.practicum.testappshop.util.ErrorType
import kotlinx.coroutines.launch

class HomeViewModel(
    private val productsInteractor: ProductsInteractor,
    private val cartInteractor: CartInteractor,
) : ViewModel() {
    private val screenStateLiveData = MutableLiveData<ProductsScreenState>()

    fun getScreenLiveData(): LiveData<ProductsScreenState> = screenStateLiveData

    fun getProducts() {
        viewModelScope.launch {
            screenStateLiveData.value = ProductsScreenState.Loading
            productsInteractor.getProducts().collect { productsOrError ->
                if (productsOrError.error != null) {
                    screenStateLiveData.value = when (productsOrError.error) {
                        ErrorType.NO_INTERNET_CONNECTION -> ProductsScreenState.ErrorNoInternet
                        ErrorType.SERVER_ERROR -> ProductsScreenState.ErrorServer
                        ErrorType.UNKNOWN_ERROR -> ProductsScreenState.UnknownError
                    }
                } else if (productsOrError.data == null) {
                    screenStateLiveData.value = ProductsScreenState.UnknownError
                } else {
                    screenStateLiveData.value = ProductsScreenState.Content(productsOrError.data!!)
                }
            }
        }
    }

    fun increaseInCart(product: Product): Boolean {
        return cartInteractor.addProductToCart(product)
    }

    fun decreaseInCart(product: Product): Boolean {
        return cartInteractor.deleteProductFromCart(product)
    }

    fun getCountInCart(productList: List<Product>): List<Long> {
        return productList.map { product -> cartInteractor.getCountInCart(product) }
    }

}