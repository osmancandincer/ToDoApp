package com.osmancandincer.todoapp.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.changePage(it:View, id:Int){
    findNavController(it).navigate(id)
}

fun Navigation.changePage(it:View, id:NavDirections){
    findNavController(it).navigate(id)
}