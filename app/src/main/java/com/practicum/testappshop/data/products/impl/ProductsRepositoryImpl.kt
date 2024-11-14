package com.practicum.testappshop.data.products.impl

import android.util.Log
import com.practicum.testappshop.data.network.ProductsApiService
import com.practicum.testappshop.data.products.ProductsRepository
import com.practicum.testappshop.domain.models.Product
import com.practicum.testappshop.util.DataOrError
import com.practicum.testappshop.util.ErrorType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class ProductsRepositoryImpl(private val productsApiService: ProductsApiService) :
    ProductsRepository {
    override fun getAllProducts(): Flow<DataOrError<List<Product>>> = flow {
        val result = try {
            val data = productsApiService.getAllProducts()
            Log.d("Data", data.toString())
            DataOrError<List<Product>>(data = data.products)
        } catch (e: HttpException) {
            DataOrError<List<Product>>(error = ErrorType.SERVER_ERROR)
        } catch (e: IOException) {
            DataOrError<List<Product>>(error = ErrorType.NO_INTERNET_CONNECTION)
        } catch (e: Exception) {
            DataOrError<List<Product>>(error = ErrorType.UNKNOWN_ERROR)
        }
        Log.d("API call result: ", result.toString())
        emit(
            result
        )
    }
}