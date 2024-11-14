# Запуск приложения

## Требования

Перед запуском убедитесь, что у вас установлены:

- Android Studio (рекомендуется последняя версия)
- Java Development Kit (JDK) 11 или выше

## Установка зависимостей

1. Склонируйте репозиторий:
   ```bash
   git clone https://github.com/ViktoriaDraenkova/Simple-Shop.git
   cd Simple-Shop
   ```

2. Откройте проект в Android Studio.

## Запуск приложения

1. Подключите ваше Android устройство или запустите эмулятор.
2. В Android Studio выберите ваше устройство в выпадающем меню.
3. Нажмите на кнопку **Run** (или используйте сочетание клавиш Shift + F10) для сборки и запуска приложения.

После успешной сборки и установки приложение запустится на вашем устройстве или эмуляторе.

## Используемые технологии

### Основные библиотеки

- **AndroidX**: Набор библиотек для поддержки новых функций Android и улучшения совместимости.
    - `androidx.core:core-ktx`: Расширения для упрощения разработки на Kotlin.
    - `androidx.appcompat:appcompat`: Поддержка старых версий Android.
    - `androidx.constraintlayout:constraintlayout`: Упрощение создания адаптивных интерфейсов.

- **Material Design**:
    - `com.google.android.material:material`: Компоненты Material Design для современного пользовательского интерфейса.

### Архитектура и управление зависимостями

- **Clean Architecture, MVVM**

- **Navigation**:
    - `androidx.navigation:navigation-fragment-ktx` и `androidx.navigation:navigation-ui-ktx`: Удобное управление навигацией в приложении.

- **Dependency Injection**:
    - `com.google.dagger:dagger` и `javax.inject:javax.inject`: Библиотеки для внедрения зависимостей.

### Сетевые запросы

- **Retrofit**:
    - `com.squareup.retrofit2:retrofit` и `com.squareup.retrofit2:converter-gson`: Библиотеки для выполнения сетевых запросов и обработки JSON.

### Работа с изображениями

- **Glide**:
    - `com.github.bumptech.glide:glide`: Библиотека для загрузки и кэширования изображений.

## Макет
![design.png](attachments%2Fdesign.png)

## Скриншоты

![Screenshot_20241114_232520.png](attachments%2FScreenshot_20241114_232520.png)
![Screenshot_20241114_232609.png](attachments%2FScreenshot_20241114_232609.png)
![Screenshot_20241114_232618.png](attachments%2FScreenshot_20241114_232618.png)
![Screenshot_20241114_232632.png](attachments%2FScreenshot_20241114_232632.png)