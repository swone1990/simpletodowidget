package com.sworon.simpletodowidget.todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sworon.simpletodowidget.repository.TodoRepository
import com.sworon.simpletodowidget.service.NetworkResult
import com.sworon.simpletodowidget.todo.model.ToDoResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    val todorepository: TodoRepository
): ViewModel() {

    private val _todos: MutableLiveData<NetworkResult<ToDoResponse>> = MutableLiveData()
    val todos: LiveData<NetworkResult<ToDoResponse>> = _todos

    fun fetchTodos() = viewModelScope.launch {
        todorepository.getTodos().collect{
            _todos.value = it
        }
    }

}