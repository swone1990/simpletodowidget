package com.sworon.simpletodowidget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.sworon.simpletodowidget.databinding.ActivityMainBinding
import com.sworon.simpletodowidget.service.NetworkResult
import com.sworon.simpletodowidget.todo.TodoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val todoViewModel by viewModels<TodoViewModel>()
    private lateinit var _binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        fetchData();
    }

    private fun fetchData(){
        todoViewModel.fetchTodos();
        todoViewModel.todos.observe(this){ response ->
            when(response) {
                is NetworkResult.Success -> {
                    response.data?.let {
                        _binding.textview.setText(response.data.data.get(0).date)
                    }
                }

                is NetworkResult.Error -> {
                    _binding.textview.setText("ERROR")
                }

                is NetworkResult.Loading-> {
                    _binding.textview.setText("Loading")
                }
            }

        }
    }
}