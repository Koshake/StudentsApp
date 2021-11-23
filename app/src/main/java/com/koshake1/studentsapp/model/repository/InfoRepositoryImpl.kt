package com.koshake1.studentsapp.model.repository

import com.koshake1.studentsapp.R
import com.koshake1.studentsapp.model.data.Classes
import com.koshake1.studentsapp.model.data.Homework
import com.koshake1.studentsapp.model.data.Info
import java.util.*

class InfoRepositoryImpl : InfoRepository {
    override fun getClasses(): List<Classes> {

        return listOf(
            Classes(
                name = "Physics", time = "8:00-8:45",
                online = true, extra = false
            ),
            Classes(
                name = "History", time = "9:00-9:45",
                online = true, extra = false
            ),
            Classes(
                name = "Literature", time = "10:00-10:45",
                online = true, extra = false
            ),
            Classes(
                name = "Geography", time = "11:00-11:45",
                online = false, extra = false
            ),
            Classes(
                name = "Sports", time = "12:00-12:45",
                online = false, extra = true
            )
        )
    }

    override fun getHomeworks(): List<Homework> {
        return listOf(
            Homework(
                name = "Physics", daysLeft = 1,
                description = "Read article about Isaac Nweton", icon = R.drawable.book2
            ),
            Homework(
                name = "History", daysLeft = 2,
                description = "Read page 100 and answer questions" , icon = R.drawable.book2
            ),
            Homework(
                name = "Geography",
                daysLeft = 1,
                description = "Nothing? just relax!",
                icon = R.drawable.book1
            ),
            Homework(
                name = "Literature", daysLeft = 5,
                description = "Learn about Pushkin",
                icon = R.drawable.book2
            ),
            Homework(
                name = "Math", daysLeft = 2,
                description = "Do something",
                icon = R.drawable.book1
            ),
            Homework(
                name = "Sports", daysLeft = 1,
                description = "Nothing",
                icon = R.drawable.book2
            )
        )

    }
    override fun getClassesInfo(): Info {
        val calendar = GregorianCalendar()
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)
        val year = calendar.get(Calendar.YEAR)
        val date = String.format(Locale.getDefault(),"%02d.%02d.%04d",day, month + 1, year)
        return Info (date, "20.12.2021", getClasses(), getHomeworks())
    }
}