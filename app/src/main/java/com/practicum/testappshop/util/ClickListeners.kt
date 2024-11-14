package com.practicum.testappshop.util

import com.practicum.testappshop.domain.models.Product

fun interface ProductClickListener {
    fun onProductClick(product: Product)
}

fun interface ButtonAddClickListener {
    fun onButtonAddClickListener(product: Product): Boolean
}

fun interface ButtonDelClickListener {
    fun onButtonDelClickListener(product: Product): Boolean
}
