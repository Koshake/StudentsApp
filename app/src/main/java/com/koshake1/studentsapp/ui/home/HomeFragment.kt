package com.koshake1.studentsapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bartex.classjobless4.ui.adapters.HomeworkAdapter
import com.koshake1.studentsapp.R
import com.koshake1.studentsapp.databinding.FragmentHomeBinding
import com.koshake1.studentsapp.model.data.Homework
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModel()
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private var homeworkAdapter : HomeworkAdapter? = null

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

        binding.textviewLessonsCount.text =
            context?.resources?.getString(R.string.Classes_today, homeworkList.size)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initClassesAdapter() {

    }

    private fun initHomeworkAdapter(list : List<Homework>) {
        if (homeworkAdapter == null) {
            homeworkAdapter = HomeworkAdapter(list)
            binding.homeworkRecyclerview.adapter = homeworkAdapter
        }
    }
}