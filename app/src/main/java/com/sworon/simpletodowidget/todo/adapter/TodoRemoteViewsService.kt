package com.sworon.simpletodowidget.todo.adapter

import android.content.Intent
import android.widget.RemoteViewsService
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoRemoteViewsService: RemoteViewsService() {

    override fun onGetViewFactory(intent: Intent?): RemoteViewsFactory {
        return TodoRemoteServiceFactory(applicationContext)
    }

}