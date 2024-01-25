package com.osmancandincer.todoapp.data.entity

import java.io.Serializable


data class Tasks(
    var task_id: String? = "",
    var task_detail: String? = ""
) : Serializable {

}
