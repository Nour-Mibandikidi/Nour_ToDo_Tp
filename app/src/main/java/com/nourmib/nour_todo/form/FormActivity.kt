package com.nourmib.nour_todo.form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.nourmib.nour_todo.R
import com.nourmib.nour_todo.tasklist.Task
import java.util.*

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        val task = intent.getSerializableExtra("task") as? Task

        val titleText = findViewById<EditText>(R.id.editTitle)
        titleText.setText(task?.title)
        val descriptionText = findViewById<EditText>(R.id.editDescription)
        descriptionText.setText(task?.description)
        val id = task?.id ?: UUID.randomUUID().toString()

        val submitButton = findViewById<Button>(R.id.button)
        submitButton.setOnClickListener {
            val newTask = Task(
                id = id,
                title = titleText.text.toString(),
                description = descriptionText.text.toString()
            )

            intent.putExtra("task", newTask)
            setResult(RESULT_OK, intent)

            finish()


            /*addTask.setOnClickListener {
            val newTask = Task(id = UUID.randomUUID().toString(), title = "New Task !")

             intent.putExtra("task", newTask)
            setResult(RESULT_OK, intent)
            finish()
        }*/


        }
    }
}