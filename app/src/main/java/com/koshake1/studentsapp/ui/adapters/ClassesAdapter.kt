package com.koshake1.studentsapp.ui.adapters

import android.provider.SyncStateContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.koshake1.studentsapp.R
import com.koshake1.studentsapp.constants.ClassesType
import com.koshake1.studentsapp.constants.FragmentType
import com.koshake1.studentsapp.databinding.ItemClassesBinding
import com.koshake1.studentsapp.databinding.ItemExtraBinding
import com.koshake1.studentsapp.model.data.Classes

class ClassesAdapter(
    private val classesList: List<Classes>,
    private val fragmentType: FragmentType
) : RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (fragmentType) {
            FragmentType.HOME -> ClassesViewHolder(inflater.inflate(R.layout.item_classes, parent, false))
            else -> when (viewType) {
                ClassesType.BASE.ordinal ->
                    ClassesViewHolder(inflater.inflate(R.layout.item_classes, parent, false))
                ClassesType.EXTRA.ordinal ->
                    ExtraClassesViewHolder(inflater.inflate(R.layout.item_extra, parent, false))
                else -> ExtraClassesViewHolder(inflater.inflate(R.layout.item_classes, parent, false))
            }
        }

    }

    override fun onBindViewHolder(holderBase: BaseViewHolder, position: Int) {
        holderBase.bind(classesList[position])
    }

    override fun getItemCount(): Int = classesList.size

    override fun getItemViewType(position: Int): Int {
        return when (classesList[position].extra) {
            true -> ClassesType.EXTRA.ordinal
            else -> ClassesType.BASE.ordinal
        }
    }

    inner class ClassesViewHolder(view: View) : BaseViewHolder(view) {

        private val binding = ItemClassesBinding.bind(view)

        override fun bind(lesson: Classes) {

            with(binding) {
                timeText.text = lesson.time
                classNameText.text = lesson.name
                if (lesson.online) {
                    shevronImage.visibility = View.VISIBLE
                    shevronView.visibility = View.VISIBLE
                } else {
                    shevronImage.visibility = View.INVISIBLE
                    shevronView.visibility = View.INVISIBLE
                }
            }
        }
    }

    inner class ExtraClassesViewHolder(view: View) : BaseViewHolder(view) {
        private val binding = ItemExtraBinding.bind(view)

        override fun bind(lesson: Classes) {

            with(binding) {
                classNameText.text = lesson.name
                timeTextview.text = lesson.time
                additionalTextview.text = lesson.description
            }
        }
    }
}