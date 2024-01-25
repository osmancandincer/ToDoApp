package com.osmancandincer.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.osmancandincer.todoapp.R
import com.osmancandincer.todoapp.databinding.FragmentHomeBinding
import com.osmancandincer.todoapp.ui.adapter.TaskAdapter
import com.osmancandincer.todoapp.ui.viewmodel.HomeViewModel
import com.osmancandincer.todoapp.util.changePage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)

        binding.homeFragment = this

        viewModel.taskList.observe(viewLifecycleOwner){
            val taskAdapter = TaskAdapter(requireContext(),it,viewModel)
            binding.taskAdapter = taskAdapter
        }

        binding.searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.search(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.search(query)
                return true
            }
        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomeViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun fabClick(it:View){
        Navigation.changePage(it,R.id.homeToNewTask)
    }
}