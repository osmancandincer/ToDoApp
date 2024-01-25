package com.osmancandincer.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.osmancandincer.todoapp.data.repo.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewTaskViewModel @Inject constructor( var trepo: TaskRepository) : ViewModel() {
    fun save (task_detail: String){
        trepo.save(task_detail)
    }
}