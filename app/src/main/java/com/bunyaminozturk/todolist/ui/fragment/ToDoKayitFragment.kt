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
import com.bunyaminozturk.todolist.databinding.FragmentToDoKayitBinding
import com.bunyaminozturk.todolist.ui.viewmodel.TodoDetayViewModel
import com.bunyaminozturk.todolist.ui.viewmodel.TodoKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ToDoKayitFragment : Fragment() {
    private lateinit var binding: FragmentToDoKayitBinding
    private lateinit var viewModel: TodoKayitViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_to_do_kayit, container, false)
        binding.todoKayitFragment = this
        binding.todoKayitToolbarBaslik = "New Todo"
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: TodoKayitViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonKaydet(todo_ad: String, todo_aciklama: String) {
        viewModel.kaydet(todo_ad, todo_aciklama)
    }

}