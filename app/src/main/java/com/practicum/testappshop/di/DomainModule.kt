package com.practicum.testappshop.di

import com.practicum.testappshop.data.cart.CartRepository
import com.practicum.testappshop.data.products.ProductsRepository
import com.practicum.testappshop.domain.cart.CartInteractor
import com.practicum.testappshop.domain.cart.impl.CartInteractorImpl
import com.practicum.testappshop.domain.products.ProductsInteractor
import com.practicum.testappshop.domain.products.impl.ProductsInteractorImpl
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideProductsInteractor(productsRepository: ProductsRepository): ProductsInteractor {
        return ProductsInteractorImpl(productsRepository)
    }

    @Provides
    fun provideCartInteractor(cartRepository: CartRepository): CartInteractor {
        return CartInteractorImpl(cartRepository)
    }
}