package com.koshake1.studentsapp.ui.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.koshake1.studentsapp.model.data.Classes

abstract class BaseViewHolder(view: View): RecyclerView.ViewHolder(view) {
    abstract fun bind(lesson : Classes)
}