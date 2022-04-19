package com.sworon.simpletodowidget.views

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.sworon.simpletodowidget.R
import com.sworon.simpletodowidget.todo.widget.TodoHomeWidgetProvider


//TODO: Want be needed anymore, because it will be a widget-only-application
@SuppressLint("RemoteViewLayout")
class TodoWidgetView constructor(
    val context: Context,
    private val packageName: String,
    private val componentName: ComponentName,
) : RemoteViews(packageName, R.layout.widget_layout) {


    fun setText(text: String) {
        buildBaseRemoteView(context)
        setTextViewText(R.id.itemTitle, text)
        updateView()
    }

    private fun buildBaseRemoteView(context: Context) {

        var intent = Intent(context, TodoHomeWidgetProvider::class.java)
        intent.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE

        val ids = AppWidgetManager.getInstance(context).getAppWidgetIds(ComponentName(context, TodoHomeWidgetProvider::class.java))
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids)

        var pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

    }

    private fun updateView() {
        AppWidgetManager.getInstance(context).updateAppWidget(componentName, this)
    }
}