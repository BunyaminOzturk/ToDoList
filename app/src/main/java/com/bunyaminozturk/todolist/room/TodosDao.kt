package com.bunyaminozturk.todolist.room

import androidx.room.Dao
import androidx.room.Query
import com.bunyaminozturk.todolist.data.entity.Todos

@Dao
interface TodosDao {
    @Query("SELECT * FROM todos")
    suspend fun todosYukle(): List<Todos>
}