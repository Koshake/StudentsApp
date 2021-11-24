package com.bartex.classjobless4.ui.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.koshake1.studentsapp.R
import com.koshake1.studentsapp.databinding.ItemHomeworkBinding
import com.koshake1.studentsapp.model.data.Homework
import java.util.*

class HomeworkAdapter (private val homeworkList : List<Homework>) :
    RecyclerView.Adapter<HomeworkAdapter.ViewHolder>() {
    lateinit var  context: Context

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HomeworkAdapter.ViewHolder {
        context = parent.context
        val view:View = LayoutInflater.from(context).inflate(R.layout.item_homework,
            parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeworkAdapter.ViewHolder, position: Int) {
        holder.bind(homeworkList[position])
    }

    override fun getItemCount(): Int {
        return  homeworkList.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val rvBinding = ItemHomeworkBinding.bind(view)

        fun bind(homework: Homework) {
            with(rvBinding) {
                homeworkClassNameText.text = homework.name
                timeLeftText.text = String.format(Locale.getDefault(),
                    context.resources.getString(R.string.days_left), homework.daysLeft)
                descriptionText.text = homework.description
            }
        }
    }
}