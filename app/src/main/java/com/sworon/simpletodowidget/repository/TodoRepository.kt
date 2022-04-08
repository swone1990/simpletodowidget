package com.sworon.simpletodowidget.repository

import androidx.lifecycle.MutableLiveData
import com.sworon.simpletodowidget.service.BaseApiResponse
import com.sworon.simpletodowidget.service.NetworkResult
import com.sworon.simpletodowidget.service.BackendTodoService
import com.sworon.simpletodowidget.todo.model.ToDoResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TodoRepository @Inject constructor(
    var backendTodoService: BackendTodoService
) : BaseApiResponse(){

    val statusLiveData = MutableLiveData<NetworkResult<ToDoResponse>>()

    fun getTodos(): Flow<NetworkResult<ToDoResponse>> {
        return flow<NetworkResult<ToDoResponse>> {
            emit(safeApiCall { backendTodoService.getTodos() })
        }.flowOn(Dispatchers.IO)
    }
}