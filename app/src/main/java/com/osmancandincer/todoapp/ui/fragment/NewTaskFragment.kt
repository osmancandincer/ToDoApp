package com.osmancandincer.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.osmancandincer.todoapp.R
import com.osmancandincer.todoapp.databinding.FragmentNewTaskBinding
import com.osmancandincer.todoapp.ui.viewmodel.NewTaskViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewTaskFragment : Fragment() {

    private lateinit var binding: FragmentNewTaskBinding
    private lateinit var viewModel: NewTaskViewModel
    private lateinit var navControl: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_new_task,container,false)

        binding.newTaskFragment = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init(view)
    }

    private fun init(view: View) {
        navControl = Navigation.findNavController(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:NewTaskViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonSave(task_detail:String){
        viewModel.save(task_detail)
        navControl.navigate(R.id.newTaskToHome)
    }

}