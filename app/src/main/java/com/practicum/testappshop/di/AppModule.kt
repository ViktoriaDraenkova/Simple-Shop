package com.practicum.testappshop.di

import android.content.Context
import com.practicum.testappshop.domain.cart.CartInteractor
import com.practicum.testappshop.domain.products.ProductsInteractor
import com.practicum.testappshop.presentation.viewmodel.cart.CartViewModelFactory
import com.practicum.testappshop.presentation.viewmodel.home.HomeViewModelFactory
import com.practicum.testappshop.presentation.viewmodel.product_details.ProductViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {
    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideHomeViewModelFactory(
        productsInteractor: ProductsInteractor,
        cartInteractor: CartInteractor
    ): HomeViewModelFactory {
        return HomeViewModelFactory(productsInteractor, cartInteractor)
    }

    @Provides
    fun provideProductDetailsViewModelFactory(
        cartInteractor: CartInteractor
    ): ProductViewModelFactory {
        return ProductViewModelFactory(cartInteractor)
    }

    @Provides
    fun provideCartViewModelFactory(
        cartInteractor: CartInteractor
    ): CartViewModelFactory {
        return CartViewModelFactory(cartInteractor)
    }
}