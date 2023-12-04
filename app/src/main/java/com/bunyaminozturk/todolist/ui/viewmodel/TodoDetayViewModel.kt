package com.bunyaminozturk.todolist.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.bunyaminozturk.todolist.data.repo.TodosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoDetayViewModel @Inject constructor(var trepo: TodosRepository) : ViewModel() {
    fun guncelle(todo_id: Int, todo_ad: String, todo_aciklama: String, todo_done: Boolean) {
        CoroutineScope(Dispatchers.Main).launch {
            trepo.guncelle(todo_id, todo_ad, todo_aciklama, todo_done)
        }
    }
}