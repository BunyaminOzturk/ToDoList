package com.bunyaminozturk.todolist.data.repo

import android.util.Log
import com.bunyaminozturk.todolist.data.datasource.TodosDataSource
import com.bunyaminozturk.todolist.data.entity.Todos

class TodosRepository(var tds:TodosDataSource) {

    suspend fun kaydet(todo_ad: String, todo_aciklama: String) = tds.kaydet(todo_ad, todo_aciklama)
    suspend fun guncelle(
        todo_id: Int,
        todo_ad: String,
        todo_aciklama: String,
        todo_done: Boolean
    ) = tds.guncelle(todo_id, todo_ad, todo_aciklama, todo_done)
    suspend fun sil(todo_id:Int) = tds.sil(todo_id)
    suspend fun todosYukle():List<Todos> = tds.todosYukle()
    suspend fun ara(aramaKelimesi: String): List<Todos> = tds.ara(aramaKelimesi)

}