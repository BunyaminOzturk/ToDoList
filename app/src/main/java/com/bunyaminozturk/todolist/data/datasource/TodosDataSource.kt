package com.bunyaminozturk.todolist.data.datasource

import android.util.Log
import com.bunyaminozturk.todolist.data.entity.Todos
import com.bunyaminozturk.todolist.room.TodosDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodosDataSource(var tdao:TodosDao) {
    suspend fun todosYukle(): List<Todos> =
        withContext(Dispatchers.IO) {
            return@withContext tdao.todosYukle()
        }

    suspend fun ara(aramaKelimesi: String): List<Todos> =
        withContext(Dispatchers.IO) {
            return@withContext tdao.ara(aramaKelimesi)
        }

    suspend fun kaydet(todo_ad: String, todo_aciklama: String) {
        val yeniTodo = Todos(0,todo_ad, todo_aciklama, false)
        tdao.kaydet(yeniTodo)
    }

    suspend fun guncelle(todo_id: Int, todo_ad: String, todo_aciklama: String, todo_done: Boolean) {
        val guncellenenTodo = Todos(todo_id,todo_ad, todo_aciklama, todo_done)
        tdao.guncelle(guncellenenTodo)
    }

    suspend fun sil(todo_id: Int) {
        val silinenTodo = Todos(todo_id, "", "", false)
        tdao.sil(silinenTodo)
    }
}