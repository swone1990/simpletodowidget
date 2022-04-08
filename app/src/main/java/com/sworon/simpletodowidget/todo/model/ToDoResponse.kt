package com.sworon.simpletodowidget.todo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ToDoResponse(
        
    @SerializedName("data")
    @Expose
    var data: List<DailyTodos>
)
