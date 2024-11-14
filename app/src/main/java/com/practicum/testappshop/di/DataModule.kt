package com.practicum.testappshop.di

import android.content.Context
import com.practicum.testappshop.data.cart.CartRepository
import com.practicum.testappshop.data.cart.impl.CartRepositoryImpl
import com.practicum.testappshop.data.network.ProductsApiService
import com.practicum.testappshop.data.products.ProductsRepository
import com.practicum.testappshop.data.products.impl.ProductsRepositoryImpl
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class DataModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideProductsApiService(retrofit: Retrofit): ProductsApiService {
        return retrofit.create(ProductsApiService::class.java)
    }

    @Provides
    fun provideProductsRepository(productsApiService: ProductsApiService): ProductsRepository {
        return ProductsRepositoryImpl(productsApiService)
    }

    @Provides
    fun provideCartRepository(context: Context): CartRepository {
        return CartRepositoryImpl(context)
    }
}