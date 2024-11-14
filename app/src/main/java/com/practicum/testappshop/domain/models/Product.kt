package com.practicum.testappshop.domain.models

/**
 * Класс, представляющий продукт.
 *
 * @property id Уникальный идентификатор продукта.
 * @property title Название продукта.
 * @property description Описание продукта.
 * @property stock Доступное количество продукта на складе.
 * @property brand Бренд продукта.
 * @property price Цена продукта.
 * @property images Список URL-адресов изображений продукта.
 * @property thumbnail URL-адрес миниатюры продукта.
 */
data class Product(
    val id: Long,
    val title: String,
    val description: String,
    val stock: Long,
    val brand: String,
    val price: Float,
    val images: List<String>,
    val thumbnail: String,
)