package com.bunyaminozturk.todolist.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bunyaminozturk.todolist.R
import com.bunyaminozturk.todolist.databinding.FragmentToDoDetayBinding
import com.bunyaminozturk.todolist.ui.viewmodel.TodoDetayViewModel
import com.bunyaminozturk.todolist.ui.viewmodel.TodoKayitViewModel

class ToDoDetayFragment : Fragment() {
    private lateinit var binding: FragmentToDoDetayBinding
    private lateinit var viewModel: TodoDetayViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_to_do_detay, container, false)
        binding.todoDetayFragment = this
        binding.todoDetayToolbarBaslik = "Todo Details"


        val bundle: ToDoDetayFragmentArgs by navArgs()
        val gelenTodo = bundle.todo
        binding.todoNesnesi = gelenTodo


        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: TodoDetayViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonGuncelle(todo_id: Int, todo_ad: String, todo_aciklama: String, todo_done:Boolean) {
        viewModel.guncelle(todo_id, todo_ad, todo_aciklama, todo_done)
    }


}