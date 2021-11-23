package com.koshake1.studentsapp.model.data

data class Info(
    val date : String,
    val examDate : String,
    val classes : List<Classes>,
    val homeworks : List<Homework>
)
