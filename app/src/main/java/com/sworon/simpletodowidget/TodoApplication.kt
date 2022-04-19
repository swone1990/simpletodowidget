package com.sworon.simpletodowidget

import android.app.Application
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import com.sworon.simpletodowidget.todo.widget.TodoHomeWidgetProvider
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltAndroidApp
class TodoApplication : Application() {
}