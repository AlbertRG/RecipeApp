package com.example.myrecipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

private val retrofit = Retrofit.Builder().baseUrl("https://www.themealdb.com/api/json/v1/1/")
    .addConverterFactory(GsonConverterFactory.create()).build()

val recipeService = retrofit.create(ApiService::class.java)

interface ApiService {

    @GET("categories.php")
    suspend fun getCategories(): CategoriesResponse

}

/*
In Kotlin, a suspend function is a function that is designed to be executed asynchronously.
It can be thought of as a function that can be paused and resumed at a later time without
blocking. suspend functions are a key feature when working with coroutines in Kotlin,
allowing for easy and efficient concurrency and asynchronous programming.

Here's a basic example of a suspend function:

--------------------------------------------------------------------------------------------
import kotlinx.coroutines.*

// Define a suspend function
suspend fun fetchData(): String {
    delay(1000) // Simulate some asynchronous operation (e.g., fetching data)
    return "Data fetched!"
}

fun main() {
    // Launch a coroutine to call the suspend function
    GlobalScope.launch {
        val result = fetchData() // Call the suspend function
        println(result)
    }

    // Important: Need to delay the main thread to keep the program running
    Thread.sleep(2000) // Wait for 2 seconds to ensure the coroutine completes
}
--------------------------------------------------------------------------------------------
In this example:

fetchData() is a suspend function because it performs a delay (simulating an asynchronous
operation).

Inside main(), GlobalScope.launch { ... } is used to launch a coroutine to call fetchData().

The suspend function fetchData() can only be called from within another coroutine or another
suspend function.

The suspend keyword indicates to the compiler and to developers that this function can
perform long-running operations or delay without blocking the thread, making it suitable for
use in asynchronous programming with coroutines.
*/