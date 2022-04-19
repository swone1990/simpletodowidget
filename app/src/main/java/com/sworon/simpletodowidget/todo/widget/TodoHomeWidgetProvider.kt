package com.sworon.simpletodowidget.todo.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.RemoteViews
import com.sworon.simpletodowidget.R
import com.sworon.simpletodowidget.service.BackendTodoService
import com.sworon.simpletodowidget.service.TodoService
import dagger.hilt.android.AndroidEntryPoint

/**
 * Implementation of App Widget functionality.
 */
@AndroidEntryPoint
class TodoHomeWidget : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            startUpdateService(context);

        }
    }

    private fun startUpdateService(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(Intent(context, TodoService::class.java))
        } else {
            context.startService(Intent(context, TodoService::class.java))
        }
    }


}