package com.nourmib.nour_todo.tasklist

data class Task (
    val id: kotlin.String,
    val title: kotlin.String,
    val description: kotlin.String = "Default") : java.io.Serializable