package com.osmancandincer.todoapp.data.datasource

import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.CollectionReference
import com.osmancandincer.todoapp.data.entity.Tasks

class TaskDataSource(var collectionTasks:CollectionReference) {

    var taskList = MutableLiveData<List<Tasks>>()

    fun taskLoad(): MutableLiveData<List<Tasks>> {

        collectionTasks.addSnapshotListener { value, error ->
            if (value != null){
                val liste = ArrayList<Tasks>()

                for (d in value.documents){
                    val task = d.toObject(Tasks::class.java)
                    if (task != null){
                        task.task_id = d.id
                        liste.add(task)
                    }
                }
                taskList.value = liste
            }
        }
        return taskList
    }

    fun search(searchWord:String):MutableLiveData<List<Tasks>>{
        collectionTasks.addSnapshotListener { value, error ->
            if (value != null){
                val liste = ArrayList<Tasks>()

                for (d in value.documents) {
                    val task = d.toObject(Tasks::class.java)
                    if (task != null) {
                        if (task.task_detail!!.lowercase().contains(searchWord.lowercase())) {
                            task.task_id = d.id
                            liste.add(task)
                        }
                    }
                }
                taskList.value = liste
            }
        }
        return taskList
        }

    fun save(task_detail:String){
        val newTask = Tasks("",task_detail)
        collectionTasks.document().set(newTask)
    }

    fun update(task_id:String,task_detail:String){
        val updateTask = HashMap<String,Any>()
        updateTask["task_detail"] = task_detail
        collectionTasks.document(task_id).update(updateTask)
    }

    fun delete(task_id: String){
        collectionTasks.document(task_id).delete()
    }
}