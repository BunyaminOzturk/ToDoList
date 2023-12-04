package com.bunyaminozturk.todolist.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "todos")
data class Todos(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "todo_id") @NotNull var todo_id: Int,
    @ColumnInfo(name = "todo_ad") @NotNull var todo_ad: String,
    @ColumnInfo(name = "todo_aciklama") @NotNull var todo_aciklama: String,
    @ColumnInfo(name = "todo_done") @NotNull var todo_done: Boolean
) : Serializable {
}