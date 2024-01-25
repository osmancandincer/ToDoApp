package com.osmancandincer.todoapp.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.osmancandincer.todoapp.data.entity.Tasks
import com.osmancandincer.todoapp.data.repo.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(var trepo: TaskRepository) : ViewModel(){

    var taskList = MutableLiveData<List<Tasks>>()

    init {
        taskLoad()
    }

    fun delete(task_id: String){
        trepo.delete(task_id)
    }

    fun taskLoad(){
        taskList = trepo.taskLoad()
    }

    fun search(searchWord: String){
        taskList = trepo.search(searchWord)
    }

}