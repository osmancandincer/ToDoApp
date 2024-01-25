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
import androidx.navigation.fragment.navArgs
import com.google.firebase.auth.FirebaseAuth
import com.osmancandincer.todoapp.R
import com.osmancandincer.todoapp.databinding.FragmentTaskDetailBinding
import com.osmancandincer.todoapp.ui.viewmodel.TaskDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TaskDetailFragment : Fragment() {

    private lateinit var binding: FragmentTaskDetailBinding
    private lateinit var viewModel: TaskDetailViewModel
    private lateinit var navControl: NavController

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_task_detail,container,false)
        binding.taskDetailFragment = this


        val bundle:TaskDetailFragmentArgs by navArgs()
        val newTask = bundle.task
        binding.taskObject = newTask

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
        val tempViewModel: TaskDetailViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonUpdate(task_id:String,task_detail:String){
        viewModel.update(task_id,task_detail)
        navControl.navigate(R.id.taskDetailToHome)
    }
}