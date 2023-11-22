package com.bunyaminozturk.todolist.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.bunyaminozturk.todolist.R
import com.bunyaminozturk.todolist.data.entity.Todos
import com.bunyaminozturk.todolist.databinding.FragmentAnasayfaBinding
import com.bunyaminozturk.todolist.ui.adapter.TodosAdapter

class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {


        binding = FragmentAnasayfaBinding.inflate(inflater,container,false)

        binding.toolbarAnasayfa.title = "Todos"

        binding.rv.layoutManager = LinearLayoutManager(requireContext())

        val todosListesi = ArrayList<Todos>()
        val td1 = Todos(1,false,"Todo 1 Title", "Todo 1 Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. ")
        val td2 = Todos(2,false,"Todo 2 Title Long title", "Todo 2 paragraph")
        val td3 = Todos(3,true,"Todo 3", "Todo 3 Todo 3")
        todosListesi.add(td1)
        todosListesi.add(td2)
        todosListesi.add(td3)

        val todosAdapater = TodosAdapter(requireContext(), todosListesi)
        binding.rv.adapter = todosAdapater


        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.todoKayitGecis)
        }

        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                ara(query)
                return true
            }
        })




        return binding.root
    }
    fun ara(aramaKelimesi:String){
        Log.e("Todo Ara ", aramaKelimesi)
    }

}