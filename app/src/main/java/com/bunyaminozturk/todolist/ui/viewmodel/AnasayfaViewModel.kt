package com.bunyaminozturk.todolist.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bunyaminozturk.todolist.data.entity.Todos
import com.bunyaminozturk.todolist.data.repo.TodosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var trepo: TodosRepository) : ViewModel() {
    var todosListesi = MutableLiveData<List<Todos>>()

    init {
        todosYukle()
    }

    fun sil(todo_id: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            trepo.sil(todo_id)
            todosYukle()
        }
    }

    fun todosYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            todosListesi.value = trepo.todosYukle()
        }
    }

    fun ara(aramaKelimesi: String) {
        CoroutineScope(Dispatchers.Main).launch {
            todosListesi.value = trepo.ara(aramaKelimesi)
        }
    }
}