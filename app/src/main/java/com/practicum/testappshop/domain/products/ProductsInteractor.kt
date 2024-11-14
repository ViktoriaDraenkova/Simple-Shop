package com.practicum.testappshop.domain.products

import com.practicum.testappshop.domain.models.Product
import com.practicum.testappshop.util.DataOrError
import kotlinx.coroutines.flow.Flow

interface ProductsInteractor {

    fun getProducts(): Flow<DataOrError<List<Product>>>

}