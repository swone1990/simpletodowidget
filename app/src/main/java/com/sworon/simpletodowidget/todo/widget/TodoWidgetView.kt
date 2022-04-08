package com.sworon.simpletodowidget.todo.widget

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import com.sworon.simpletodowidget.R

@SuppressLint("RemoteViewLayout")
class TodoWidgetView constructor(
    val context: Context,
    private val packageName: String,
    private val componentName: ComponentName,
) : RemoteViews(packageName, R.layout.todo_home_widget) {


    fun setText(text: String) {
        buildBaseRemoteView(context)
        setTextViewText(R.id.appwidget_text, text)
        updateView()
    }

    private fun buildBaseRemoteView(context: Context) {

        var intent = Intent(context, TodoHomeWidget::class.java)
        intent.action = AppWidgetManager.ACTION_APPWIDGET_UPDATE

        val ids = AppWidgetManager.getInstance(context).getAppWidgetIds(ComponentName(context, TodoHomeWidget::class.java))
        intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids)

        var pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        //setOnClickPendingIntent(R.id.widgetHeaderRefreshImageView, pendingIntent)

        //intent = Intent(context, SplashScreenActivity::class.java)
        //pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
        //setOnClickPendingIntent(R.id.widgetContentLinearLayout, pendingIntent)
    }

    private fun updateView() {
        AppWidgetManager.getInstance(context).updateAppWidget(componentName, this)
    }
}