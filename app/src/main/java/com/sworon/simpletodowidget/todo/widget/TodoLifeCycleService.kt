package com.sworon.simpletodowidget.todo.widget

import android.app.Service
import android.content.ComponentName
import android.content.Intent
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.asLiveData
import com.sworon.simpletodowidget.repository.TodoRepository
import com.sworon.simpletodowidget.todo.adapter.CustomeExpandableTodoListAdapter
import com.sworon.simpletodowidget.todo.model.DailyTodos
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class TodoLifeCycleService : LifecycleService(){

    @Inject
    lateinit var todoRepository: TodoRepository

    private var todoWidgetView: TodoWidgetView? = null

    var expandableTodoListAdapter: CustomeExpandableTodoListAdapter ?= null

    override fun onCreate() {
        super.onCreate()
        initAdapter()
    }

    private fun initAdapter() {
        todoWidgetView = TodoWidgetView(applicationContext, packageName, getComponentName())


    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)

        todoRepository.getTodos().asLiveData().observe(this, {
            if(it != null){
                showWidgetTodo(it.data!!.data.get(0))
            }
        })
        return Service.START_STICKY
    }


    private fun showWidgetTodo(todos: DailyTodos){
        todoWidgetView = TodoWidgetView(applicationContext, packageName, getComponentName())
        todoWidgetView!!.setText(todos.date);
    }

    private fun getComponentName(): ComponentName {
        return ComponentName(this@TodoLifeCycleService, TodoHomeWidget::class.java)
    }


    companion object {

        const val SERVICE_NOTIFICATION_CHANNEL = "todo Channel"
    }
}