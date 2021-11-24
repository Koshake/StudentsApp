package com.koshake1.studentsapp.app

import android.app.Application
import com.koshake1.studentsapp.koin.repositoryModule
import com.koshake1.studentsapp.koin.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class StudentApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@StudentApp)
            loadKoinModules(
                listOf(
                    repositoryModule,
                    viewModelModule,
                )
            )
        }
    }
}