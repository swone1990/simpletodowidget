package com.sworon.simpletodowidget.todo.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.lang.StringBuilder
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

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

) {
    private fun getLocalDateTime(): LocalDateTime {
        date.removeSuffix("\\")
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        val dt = LocalDateTime.parse(date, formatter);

        return dt
    }

    fun getDateString(): String {
        var localDateTime: LocalDateTime = getLocalDateTime()
        var sb: StringBuilder = StringBuilder()
        sb.append(localDateTime.dayOfWeek.name)
        sb.append(": ")
        sb.append(localDateTime.year)
        sb.append("-")
        sb.append(localDateTime.month.value)
        sb.append("-")
        sb.append(localDateTime.dayOfMonth)


        return sb.toString()
    }
}
