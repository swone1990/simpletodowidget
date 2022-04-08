package com.sworon.simpletodowidget.service

import com.sworon.simpletodowidget.Constants
import com.sworon.simpletodowidget.todo.model.ToDoResponse
import retrofit2.Response
import retrofit2.http.GET

interface BackendTodoService {

    @GET(Constants.BASE_URL +"/todo")
    suspend fun getTodos(): Response<ToDoResponse>

}
