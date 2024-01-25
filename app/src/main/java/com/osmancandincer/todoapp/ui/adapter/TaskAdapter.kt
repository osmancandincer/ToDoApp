package com.osmancandincer.todoapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.osmancandincer.todoapp.R
import com.osmancandincer.todoapp.data.entity.Tasks
import com.osmancandincer.todoapp.databinding.CardDesignBinding
import com.osmancandincer.todoapp.ui.fragment.HomeFragmentDirections
import com.osmancandincer.todoapp.ui.viewmodel.HomeViewModel
import com.osmancandincer.todoapp.util.changePage

class TaskAdapter (var mContext: Context, var taskList: List<Tasks>,var viewModel: HomeViewModel) :
RecyclerView.Adapter<TaskAdapter.cardHolder>(){

    inner class cardHolder (var design: CardDesignBinding):
            RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardHolder {
        val binding : CardDesignBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.card_design,parent,false)
        return cardHolder(binding)
    }

    override fun onBindViewHolder(holder: cardHolder, position: Int) {
        val task = taskList.get(position)
        val d =holder.design

        d.taskObject = task

        d.cardViewLine.setOnClickListener {
            val change = HomeFragmentDirections.homeToTaskDetail(task = task)
            Navigation.changePage(it,change)
        }

        d.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"${task.task_detail} Silinsin mi?",Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    viewModel.delete(task.task_id!!)
                }
                .show()
        }
    }

    override fun getItemCount(): Int {
        return taskList.size
    }
}