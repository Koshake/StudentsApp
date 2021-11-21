package com.koshake1.studentsapp.ui.classes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.koshake1.studentsapp.databinding.FragmentClassesBinding

class ClassesFragment : Fragment() {

    private lateinit var classesViewModel: ClassesViewModel
    private var _binding: FragmentClassesBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        classesViewModel =
            ViewModelProvider(this).get(ClassesViewModel::class.java)

        _binding = FragmentClassesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textDashboard
        classesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}