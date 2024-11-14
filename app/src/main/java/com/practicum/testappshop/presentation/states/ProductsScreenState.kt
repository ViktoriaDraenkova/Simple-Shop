package com.practicum.testappshop.presentation.states

import com.practicum.testappshop.domain.models.Product

sealed interface ProductsScreenState {
    data object Loading : ProductsScreenState

    data class Content(val data: List<Product>) : ProductsScreenState

    data object ErrorNoInternet : ProductsScreenState

    data object ErrorServer : ProductsScreenState

    data object UnknownError : ProductsScreenState

}