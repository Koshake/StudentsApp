package com.koshake1.studentsapp.koin

import com.koshake1.studentsapp.model.repository.InfoRepository
import com.koshake1.studentsapp.model.repository.InfoRepositoryImpl
import com.koshake1.studentsapp.ui.classes.ClassesViewModel
import com.koshake1.studentsapp.ui.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModule = module {
    single<InfoRepository> { InfoRepositoryImpl() }
}

val viewModelModule = module {
    viewModel { ClassesViewModel(get()) }
    viewModel { HomeViewModel(get()) }
}