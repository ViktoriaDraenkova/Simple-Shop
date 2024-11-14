package com.practicum.testappshop.util

/**
 * Что угодно или ошибка.
 *
 * @param T Тип данных.
 * @property data Данные или null при ошибке.
 * @property error Информация об ошибке, если она произошла; null в противном случае.
 */
data class DataOrError<T>(
    val data: T? = null,
    val error: ErrorType? = null,
)

enum class ErrorType {
    NO_INTERNET_CONNECTION,
    UNKNOWN_ERROR,
    SERVER_ERROR,
}