package com.nourmib.nour_todo.tasklist

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.nourmib.nour_todo.R
import com.nourmib.nour_todo.form.FormActivity
import java.util.*


class TaskListFragment : Fragment() {
    private val adapter = TaskListAdapter();
    private var taskList = listOf(
        Task(id = "id_1", title = "Task 1", description = "description 1"),
        Task(id = "id_2", title = "Task 2", description = "Description 2"),
        Task(id = "id_3", title = "Task 3", description = "description 3")
    )
//creation de task
    val createTask = registerForActivityResult(StartActivityForResult()) { result ->
        val task = result.data?.getSerializableExtra("task") as? Task
            ?: return@registerForActivityResult
        taskList = taskList + task
        refreshList()
    }
//modifier task
    val modifyTask = registerForActivityResult(StartActivityForResult()) { result ->

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter.currentList = taskList;
        val rootView = inflater.inflate(R.layout.fragment_task_list, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.fragment_tasklist)
        recyclerView.adapter = adapter

        val addButton = view.findViewById<FloatingActionButton>(R.id.floatingActionButton)

        addButton.setOnClickListener {
            val intent = Intent(context, FormActivity::class.java)
            createTask.launch(intent)

        }

        adapter.onClickDelete = { task ->
            taskList = taskList - task

            refreshList()
        }

    }

    private fun refreshList() {
        adapter.currentList = taskList
        adapter.notifyDataSetChanged()
    }
}


