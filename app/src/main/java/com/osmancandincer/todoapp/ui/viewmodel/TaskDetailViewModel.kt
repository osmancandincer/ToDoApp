package com.osmancandincer.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.osmancandincer.todoapp.data.repo.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TaskDetailViewModel @Inject constructor(var trepo: TaskRepository) : ViewModel() {

    fun update(task_id: String, task_detail: String){
        trepo.update(task_id,task_detail)
    }
}