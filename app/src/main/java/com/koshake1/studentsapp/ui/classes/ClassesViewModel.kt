package com.koshake1.studentsapp.ui.classes

import androidx.lifecycle.ViewModel
import com.koshake1.studentsapp.model.repository.InfoRepository

class ClassesViewModel(private val repository: InfoRepository) : ViewModel() {
        fun getClasses() = repository.getClasses()
}