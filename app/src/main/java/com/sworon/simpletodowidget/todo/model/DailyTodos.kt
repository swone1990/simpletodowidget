package com.sworon.simpletodowidget.todo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DailyTodos(

    @SerializedName("id")
    @Expose
    val id: Long,

    @SerializedName("todos")
    @Expose
    val todos: List<ToDo>,

    @SerializedName("date")
    @Expose
    val date: String

)
