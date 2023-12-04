package com.bunyaminozturk.todolist.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.bunyaminozturk.todolist.R
import com.bunyaminozturk.todolist.data.entity.Todos
import com.bunyaminozturk.todolist.databinding.FragmentAnasayfaBinding
import com.bunyaminozturk.todolist.ui.adapter.TodosAdapter
import com.bunyaminozturk.todolist.ui.viewmodel.AnasayfaViewModel
import com.bunyaminozturk.todolist.ui.viewmodel.TodoKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {


        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa,container,false)
        binding.anasayfaFragment = this
        binding.anasayfaToolbarBaslik = "Todos"

        viewModel.todosListesi.observe(viewLifecycleOwner){
            val todosAdapater = TodosAdapter(requireContext(), it, viewModel)
            binding.todosAdapter = todosAdapater
        }




        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.ara(query)
                return true
            }
        })
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fabTikla(it:View){
        Navigation.findNavController(it).navigate(R.id.todoKayitGecis)
    }

    override fun onResume() {
        super.onResume()
        viewModel.todosYukle()
    }

}