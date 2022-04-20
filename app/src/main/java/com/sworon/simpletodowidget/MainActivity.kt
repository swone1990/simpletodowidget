package com.sworon.simpletodowidget

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.sworon.simpletodowidget.databinding.ActivityMainBinding
import com.sworon.simpletodowidget.service.NetworkResult
import com.sworon.simpletodowidget.service.TodoApiInterface
import com.sworon.simpletodowidget.todo.TodoViewModel
import com.sworon.simpletodowidget.todo.model.DailyTodos
import com.sworon.simpletodowidget.todo.model.ToDoResponse
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val todoViewModel by viewModels<TodoViewModel>()
    private lateinit var _binding: ActivityMainBinding

    //TODO: Want be needed anymore, because it will be a widget-only-application
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        val todoCall =  TodoApiInterface.create()
        todoCall.getTodos().enqueue(object: Callback<ToDoResponse> {
            override fun onResponse(call: Call<ToDoResponse>, response: Response<ToDoResponse>) {
                val todoResponse = response.body()
                val dailyTodos = todoResponse!!.data
                _binding.textview.setText(dailyTodos.get(0).getDateString())
            }

            override fun onFailure(call: Call<ToDoResponse>, t: Throwable) {
                showError(t.message)
            }

        })
    }

    private fun showError(message: String?) {
        toast(message.toString())
    }

    fun Context.toast(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }

//
}

