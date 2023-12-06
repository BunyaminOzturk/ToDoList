package com.bunyaminozturk.todolist.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.bunyaminozturk.todolist.data.entity.Todos
import javax.inject.Singleton

@Dao
interface TodosDao {
    @Query("SELECT * FROM todos")
    suspend fun todosYukle(): List<Todos>

    @Insert
    suspend fun kaydet(todo: Todos)

    @Update
    suspend fun guncelle(todo: Todos)

    @Delete
    suspend fun sil(todo: Todos)

    @Query("select * from todos where todo_ad like '%' || :aramaKelimesi || '%'")
    suspend fun ara(aramaKelimesi: String): List<Todos>

}