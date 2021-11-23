package com.koshake1.studentsapp.model.repository

import com.koshake1.studentsapp.model.data.Classes
import com.koshake1.studentsapp.model.data.Homework
import com.koshake1.studentsapp.model.data.Info

interface InfoRepository {

    fun getClassesInfo() : Info

    fun getClasses() : List<Classes>

    fun getHomeworks() : List<Homework>
}