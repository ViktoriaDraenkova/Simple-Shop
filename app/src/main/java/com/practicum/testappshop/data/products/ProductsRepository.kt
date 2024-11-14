package com.practicum.testappshop.data.products

import com.practicum.testappshop.domain.models.Product
import com.practicum.testappshop.util.DataOrError
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    /**
     * Получает список всех продуктов из API.
     *
     * Метод выполняет запрос к API для получения всех продуктов и возвращает результаты
     * в виде потока (Flow).
     *
     * @return Поток (Flow), содержащий объект типа [DataOrError], который может содержать
     *         список продуктов или информацию об ошибке.
     */
    fun getAllProducts(): Flow<DataOrError<List<Product>>>
}