package com.nourmib.nour_todo.tasklist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nourmib.nour_todo.R

class TaskListAdapter : RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>() {

    var currentList: List<Task> = emptyList()
    var onClickDelete: (Task) -> Unit = {}
    //var onClickModify: (Task) -> = {}

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView = itemView.findViewById<TextView>(R.id.task_title);
        val descriptionTextView = itemView.findViewById<TextView>(R.id.task_description);
        val deleteButton = itemView.findViewById<ImageButton>(R.id.imageButton)
        fun bind(task: Task) {

            titleTextView.text = task.title
            descriptionTextView.text = task.description
            deleteButton.setOnClickListener { onClickDelete(task) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(itemView)


        }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    override fun getItemCount(): Int {
        return currentList.size
    }
}

