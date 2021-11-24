package com.koshake1.studentsapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.koshake1.studentsapp.R
import com.koshake1.studentsapp.databinding.FragmentHomeBinding
import com.koshake1.studentsapp.model.data.Classes
import com.koshake1.studentsapp.model.data.Homework
import com.koshake1.studentsapp.ui.adapters.ClassesAdapter
import com.koshake1.studentsapp.ui.adapters.HomeworkAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private var homeworkAdapter : HomeworkAdapter? = null

    private var classesAdapter : ClassesAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeworkList = homeViewModel.getClassesInfo().homeworks
        initHomeworkAdapter(homeworkList)

        val classesList = homeViewModel.getClassesInfo().classes
        initClassesAdapter(classesList)
        binding.textviewLessonsCount.text =
            context?.resources?.getString(R.string.Classes_today, classesList.size)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initHomeworkAdapter(list : List<Homework>) {
        if (homeworkAdapter == null) {
            homeworkAdapter = HomeworkAdapter(list)
            binding.homeworkRecyclerview.adapter = homeworkAdapter
        }
    }

    private fun initClassesAdapter(list : List<Classes>) {
        if (classesAdapter == null) {
            classesAdapter = ClassesAdapter(list)
            binding.classesRecyclerview.adapter = classesAdapter
        }
    }
}