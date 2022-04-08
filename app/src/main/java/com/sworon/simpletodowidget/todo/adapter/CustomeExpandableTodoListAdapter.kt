package com.sworon.simpletodowidget.todo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import com.sworon.simpletodowidget.R
import com.sworon.simpletodowidget.todo.model.DailyTodos
import com.sworon.simpletodowidget.todo.model.ToDoResponse
import javax.inject.Inject

class CustomeExpandableTodoListAdapter @Inject constructor(
    private val context: Context
) : BaseExpandableListAdapter() {

    private var toDoResponse: ToDoResponse? = null

    override fun getGroupCount(): Int {
        toDoResponse!!.data.size
        TODO("Not yet implemented")
    }

    override fun getChildrenCount(p0: Int): Int {
        return toDoResponse!!.data.get(p0).todos.size
    }

    override fun getGroup(p0: Int): DailyTodos {
        return toDoResponse!!.data.get(p0)
    }

    override fun getChild(p0: Int, p1: Int): Any {
        return toDoResponse!!.data.get(p0).todos.get(p1)
    }

    override fun getGroupId(p0: Int): Long {
        return toDoResponse!!.data.get(p0).id
    }

    override fun getChildId(p0: Int, p1: Int): Long {
        return toDoResponse!!.data.get(p0).todos.get(p1).id
    }

    override fun hasStableIds(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        var date = getGroup(groupPosition).date

        if (convertView == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(R.layout.list_group, null)
        }
        var dateTextView = convertView!!.findViewById<TextView>(R.id.dailyTodoDate)
        dateTextView.setText(date)
        return convertView
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        TODO("Not yet implemented")
    }

    override fun isChildSelectable(p0: Int, p1: Int): Boolean {
        TODO("Not yet implemented")
    }
}