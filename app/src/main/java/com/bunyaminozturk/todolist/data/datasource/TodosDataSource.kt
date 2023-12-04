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
            val todosListesi = ArrayList<Todos>()
            val td1 = Todos(
                1,
                "Todo 1 Title",
                "Todo 1 Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                false )
            todosListesi.add(td1)
            return@withContext todosListesi
        }

    suspend fun kaydet(todo_ad: String, todo_aciklama: String) {
        Log.e("Todo Kaydet", "$todo_ad - $todo_aciklama ")
    }

    suspend fun guncelle(todo_id: Int, todo_ad: String, todo_aciklama: String, todo_done: Boolean) {
        Log.e("Todo Güncelle", "$todo_id - $todo_ad - $todo_aciklama - $todo_done")
    }

    suspend fun sil(todo_id: Int) {
        Log.e("Todo sil", todo_id.toString())
    }
}