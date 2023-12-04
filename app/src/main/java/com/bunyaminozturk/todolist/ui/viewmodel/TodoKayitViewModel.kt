package com.bunyaminozturk.todolist.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.bunyaminozturk.todolist.data.repo.TodosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoKayitViewModel @Inject constructor(var trepo: TodosRepository) : ViewModel() {
    fun kaydet(todo_ad: String, todo_aciklama: String) {
        CoroutineScope(Dispatchers.Main).launch {
            trepo.kaydet(todo_ad, todo_aciklama)
        }

    }
}