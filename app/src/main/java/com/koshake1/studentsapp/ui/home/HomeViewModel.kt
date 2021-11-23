package com.koshake1.studentsapp.ui.home

import androidx.lifecycle.ViewModel
import com.koshake1.studentsapp.model.repository.InfoRepository

class HomeViewModel(private val repository: InfoRepository) : ViewModel() {

    fun getClassesInfo() = repository.getClassesInfo()
}