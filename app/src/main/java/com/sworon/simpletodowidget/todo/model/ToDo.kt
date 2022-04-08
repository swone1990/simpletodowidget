package com.sworon.simpletodowidget.todo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime

data class ToDo(


    @SerializedName("id")
    @Expose
    val id: Long,

    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("created_at")
    @Expose
    val createdAt: String,
    @SerializedName("status")
    @Expose
    val status: String
)