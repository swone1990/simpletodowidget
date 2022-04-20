package com.sworon.simpletodowidget.service

import com.google.gson.GsonBuilder
import com.sworon.simpletodowidget.Constants.Companion.BASE_URL
import com.sworon.simpletodowidget.todo.model.ToDoResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface TodoApiInterface {

    @GET("api.php")
    fun getTodos(): Call<ToDoResponse>


    companion object Factory {
        fun create(): TodoApiInterface {
//            val gson = GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").create()
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(TodoApiInterface::class.java)
        }
    }

}