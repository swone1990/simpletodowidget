package com.sworon.simpletodowidget.todo.widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.net.Uri

import android.widget.RemoteViews
import com.sworon.simpletodowidget.R
import com.sworon.simpletodowidget.service.TodoApiInterface
import com.sworon.simpletodowidget.todo.adapter.TodoRemoteViewsService
import com.sworon.simpletodowidget.todo.model.ToDoResponse
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response


/**
 * Implementation of App Widget functionality.
 */

class TodoHomeWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {



        appWidgetIds.forEach { appWidgetId ->
            val intent = Intent(context, TodoRemoteViewsService::class.java).apply {
                putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId)
                data = Uri.parse(toUri(Intent.URI_INTENT_SCHEME))
            }

            val views = RemoteViews(context.packageName, R.layout.widget_layout).apply {
                // Set up the RemoteViews object to use a RemoteViews adapter.
                // This adapter connects to a RemoteViewsService through the
                // specified intent.
                // This is how you populate the data.
                setRemoteAdapter(R.id.todo_list, intent)

                // The empty view is displayed when the collection has no items.
                // It should be in the same layout used to instantiate the
                // RemoteViews object.
                setEmptyView(R.id.todo_list, R.id.empty)
            }
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds)
    }
}