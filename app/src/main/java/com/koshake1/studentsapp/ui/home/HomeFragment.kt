package com.koshake1.studentsapp.ui.home

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.SyncStateContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.koshake1.studentsapp.R
import com.koshake1.studentsapp.constants.FragmentType
import com.koshake1.studentsapp.constants.URL
import com.koshake1.studentsapp.databinding.FragmentHomeBinding
import com.koshake1.studentsapp.model.data.Classes
import com.koshake1.studentsapp.model.data.Homework
import com.koshake1.studentsapp.ui.adapters.ClassesAdapter
import com.koshake1.studentsapp.ui.adapters.HomeworkAdapter
import com.koshake1.studentsapp.ui.adapters.OnVideoItemClickListener
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(), VideoOpener {

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
        }
        binding.homeworkRecyclerview.adapter = homeworkAdapter
    }

    private fun initClassesAdapter(list : List<Classes>) {
        if (classesAdapter == null) {
            classesAdapter = ClassesAdapter(list, FragmentType.HOME,
            object : OnVideoItemClickListener {
                override fun onItemClicked() {
                    openVideoApp()
                }
            })
        }
        binding.classesRecyclerview.adapter = classesAdapter
    }

    override fun openVideoApp() {
        val uri = Uri.parse(URL)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        try {
            startActivity(intent)
        } catch (e : PackageManager.NameNotFoundException) {
            Toast.makeText(context, "Can't open Skype!", Toast.LENGTH_LONG).show()
        } catch (e : ActivityNotFoundException) {
            Toast.makeText(context, "Install Skype!", Toast.LENGTH_LONG).show()
        }
    }
}