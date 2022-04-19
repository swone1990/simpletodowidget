package com.sworon.simpletodowidget.todo.adapter

import android.content.Context
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import com.sworon.simpletodowidget.R
import com.sworon.simpletodowidget.service.TodoApiInterface
import com.sworon.simpletodowidget.todo.model.DailyTodos


class TodoRemoteServiceFactory constructor(
    context: Context,
//    private val repository: DataRepository
) : RemoteViewsService.RemoteViewsFactory {

    data class WidgetItem(val text: String)
    private var widgetItems: List<WidgetItem> = emptyList()
    private var todos: List<List<String>> = emptyList()


    var mContext: Context? = context

    private val ID_CONSTANT = 0x0101010

    override fun onCreate() {

    }

    //TODO: the data should be coming form the repository, which get the data from roomdb
    override fun onDataSetChanged() {

//        widgetItems = repository.data.value.map { WidgetItem(it.name) }
        val todoCall = TodoApiInterface.create()
        var response = todoCall.getTodos().execute()
        widgetItems = response.body()!!.data.map { WidgetItem((it.date)) }
        todos = generateTodoDataForWidget(response.body()!!.data)
    }

    override fun onDestroy() {
        todos = emptyList()
    }

    override fun getCount(): Int {
        return todos.size
    }

    //TODO: Check why the first listItem sets the itemStateTextView
    override fun getViewAt(p0: Int): RemoteViews {
        return RemoteViews(mContext!!.packageName, R.layout.list_child).apply {
            if (todos.get(p0).size < 2) {
                setTextViewText(R.id.itemTitle, todos.get(p0).get(0))

            } else if (todos.get(p0).size > 1) {
                setTextViewText(R.id.itemTitle, todos.get(p0).get(0))
                setTextViewText(R.id.itemState, todos.get(p0).get(1))
            }
        }
    }

    override fun getLoadingView(): RemoteViews? {
       return null
    }

    override fun getViewTypeCount(): Int {
        return 1
    }

    override fun getItemId(p0: Int): Long {
        return todos[p0].hashCode().toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    }

    //TODO: This code should be moved to the modelClass ToDoResponse
    private fun generateTodoDataForWidget(dailyTodos: List<DailyTodos>): MutableList<MutableList<String>> {
        var dataForWidget: MutableList<MutableList<String>> = ArrayList()

        dailyTodos.forEach { dailyTodos ->
            var dateList: MutableList<String> = ArrayList()
            dateList.add(dailyTodos.date)

            dataForWidget.add(dateList)
            dailyTodos.todos.forEach {
                var todoList: MutableList<String> = ArrayList()
                todoList.add(it.title)
                todoList.add(it.status)
                dataForWidget.add(todoList)
            }

        }
        return dataForWidget
    }

