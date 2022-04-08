package com.sworon.simpletodowidget.todo.widget

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.widget.RemoteViews
import android.widget.RemoteViewsService

class TodoRemoteServiceFactory constructor(
    val applicationContext: Context,
    val intent: Intent
): RemoteViewsService.RemoteViewsFactory {


    private val mContext: Context? = applicationContext
    private val mCursor: Cursor? = null



    override fun onCreate() {
        TODO("Not yet implemented")
    }

    override fun onDataSetChanged() {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        TODO("Not yet implemented")
    }

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getViewAt(p0: Int): RemoteViews {
        TODO("Not yet implemented")
    }

    override fun getLoadingView(): RemoteViews {
        TODO("Not yet implemented")
    }

    override fun getViewTypeCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItemId(p0: Int): Long {
        TODO("Not yet implemented")
    }

    override fun hasStableIds(): Boolean {
        TODO("Not yet implemented")
    }
}