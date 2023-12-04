package com.bunyaminozturk.todolist.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bunyaminozturk.todolist.data.entity.Todos

@Database(entities = [Todos::class], version = 1)
abstract class Veritabani : RoomDatabase() {
    abstract fun getTodosDao(): TodosDao

}