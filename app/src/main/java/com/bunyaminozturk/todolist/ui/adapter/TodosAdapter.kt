package com.bunyaminozturk.todolist.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bunyaminozturk.todolist.data.entity.Todos
import com.bunyaminozturk.todolist.databinding.CardTasarimBinding
import com.bunyaminozturk.todolist.databinding.FragmentAnasayfaBinding
import com.bunyaminozturk.todolist.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class TodosAdapter(var mContext: Context, var todosListesi: List<Todos>) :
    RecyclerView.Adapter<TodosAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var tasarim: CardTasarimBinding) :
        RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val todo = todosListesi.get(position)
        val t = holder.tasarim

        t.textViewTodoAd.text = todo.todo_ad
        t.textViewTodoAciklama.text = todo.todo_aciklama
        t.checkBox.isChecked = todo.todo_done

        t.cardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.todoDetayGecis(todo = todo)
            Navigation.findNavController(it).navigate(gecis)
        }

        t.imageViewSil.setOnClickListener {
            MaterialAlertDialogBuilder(mContext)
                .setTitle(todo.todo_ad)
                .setMessage(todo.todo_aciklama + "\n Delete?")
                .setPositiveButton("Delete"){ d, i ->
                    Toast.makeText(mContext, "${todo.todo_ad} Deleted", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Cancel"){d, i, ->
                    Toast.makeText(mContext, "Cancelled", Toast.LENGTH_SHORT).show()
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return todosListesi.size
    }
    fun sil(todo_id:Int){
        Log.e("Todo sil", todo_id.toString())
    }


}