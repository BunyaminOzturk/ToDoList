package com.bunyaminozturk.todolist.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.bunyaminozturk.todolist.R
import com.bunyaminozturk.todolist.databinding.FragmentToDoDetayFragmentBinding

class ToDoDetayFragmentFragment : Fragment() {
    private lateinit var binding: FragmentToDoDetayFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentToDoDetayFragmentBinding.inflate(inflater, container, false)

        binding.toolbarToDoDetay.title = "Todo Details"


        val bundle: ToDoDetayFragmentFragmentArgs by navArgs()
        val gelenTodo = bundle.todo

        binding.editTextTodoAd.setText(gelenTodo.todo_ad)
        binding.editTextTodoAciklama.setText(gelenTodo.todo_aciklama)
        binding.checkBoxDoneGuncelle.isChecked = gelenTodo.todo_done

        binding.buttonGuncelle.setOnClickListener {
            val todo_ad = binding.editTextTodoAd.text.toString()
            val todo_aciklama = binding.editTextTodoAciklama.text.toString()
            val todo_done = binding.checkBoxDoneGuncelle.isChecked

            guncelle(gelenTodo.todo_id, todo_ad, todo_aciklama, todo_done)
        }


        return binding.root
    }

    fun guncelle(todo_id: Int, todo_ad: String, todo_aciklama: String, todo_done:Boolean) {
        Log.e("Todo Güncelle", "$todo_id - $todo_ad - $todo_aciklama - $todo_done")
    }


}