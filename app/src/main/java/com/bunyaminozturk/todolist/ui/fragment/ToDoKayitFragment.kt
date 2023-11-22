package com.bunyaminozturk.todolist.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bunyaminozturk.todolist.R
import com.bunyaminozturk.todolist.databinding.FragmentToDoKayitBinding

class ToDoKayitFragment : Fragment() {
    private lateinit var binding: FragmentToDoKayitBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentToDoKayitBinding.inflate(inflater, container, false)

        binding.toolbarToDoKayit.title = "New Todo"


        binding.buttonKaydet.setOnClickListener {
            val todo_ad = binding.editTextTodoAd.text.toString()
            val todo_aciklama = binding.editTextTodoAciklama.text.toString()
            val todo_done = false

            kaydet(todo_ad, todo_aciklama, todo_done)
        }


        return binding.root
    }

    fun kaydet(todo_ad:String, todo_aciklama:String, todo_done:Boolean){
        Log.e("Todo Kaydet", "$todo_ad - $todo_aciklama - $todo_done")
    }

}