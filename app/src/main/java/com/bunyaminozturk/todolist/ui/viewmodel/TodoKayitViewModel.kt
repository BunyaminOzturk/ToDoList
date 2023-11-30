package com.bunyaminozturk.todolist.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.bunyaminozturk.todolist.data.repo.TodosRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoKayitViewModel : ViewModel() {
    var trepo = TodosRepository()
    fun kaydet(todo_ad: String, todo_aciklama: String) {
        CoroutineScope(Dispatchers.Main).launch {
            trepo.kaydet(todo_ad, todo_aciklama)
        }

    }
}