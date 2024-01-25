package com.osmancandincer.todoapp.data.repo

import androidx.lifecycle.MutableLiveData
import com.osmancandincer.todoapp.data.datasource.TaskDataSource
import com.osmancandincer.todoapp.data.entity.Tasks
import javax.inject.Inject

class TaskRepository @Inject constructor(var tds: TaskDataSource) {

    fun save(task_detail:String) = tds.save(task_detail)

    fun update(task_id: String,task_detail: String) = tds.update(task_id, task_detail)

    fun delete(task_id: String) = tds.delete(task_id)

    fun taskLoad(): MutableLiveData<List<Tasks>> = tds.taskLoad()

    fun search (searchWord: String): MutableLiveData<List<Tasks>> = tds.search(searchWord)
}