package com.bunyaminozturk.todolist.data.entity

import java.io.Serializable

data class Todos(var todo_id: Int,
                 var todo_done:Boolean,
                 var todo_ad: String,
                 var todo_aciklama: String):Serializable {
}