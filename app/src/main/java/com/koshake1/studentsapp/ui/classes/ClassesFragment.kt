package com.koshake1.studentsapp.ui.classes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.koshake1.studentsapp.R
import com.koshake1.studentsapp.constants.FragmentType
import com.koshake1.studentsapp.databinding.FragmentClassesBinding
import com.koshake1.studentsapp.model.data.Classes
import com.koshake1.studentsapp.ui.adapters.ClassesAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class ClassesFragment : Fragment() {

    private val classesViewModel: ClassesViewModel by viewModel()
    private var _binding: FragmentClassesBinding? = null

    private val binding get() = _binding!!

    private var classesAdapter : ClassesAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentClassesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter(classesViewModel.getClasses())
        binding.textviewClassesDate.text =
            context?.resources?.getString(R.string.today, classesViewModel.getDate())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initAdapter(list : List<Classes>) {
        if (classesAdapter == null) {
            classesAdapter = ClassesAdapter(list, FragmentType.CLASSES)
        }
        binding.classesRecyclerview.adapter = classesAdapter
    }
}