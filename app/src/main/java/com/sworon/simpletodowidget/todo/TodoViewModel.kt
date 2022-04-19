package com.sworon.simpletodowidget.todo

import androidx.lifecycle.*
import com.sworon.simpletodowidget.repository.TodoRepository
import com.sworon.simpletodowidget.service.NetworkResult
import com.sworon.simpletodowidget.todo.model.DailyTodos
import com.sworon.simpletodowidget.todo.model.ToDoResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(

): ViewModel() {

    private val _todos: MutableLiveData<NetworkResult<ToDoResponse>> = MutableLiveData()
    val todos: LiveData<NetworkResult<ToDoResponse>> = _todos
}