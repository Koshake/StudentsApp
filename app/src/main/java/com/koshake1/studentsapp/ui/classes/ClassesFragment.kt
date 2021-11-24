package com.koshake1.studentsapp.ui.classes

import android.R.attr
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
import android.R.attr.path
import android.content.ActivityNotFoundException

import android.content.pm.PackageManager

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import com.koshake1.studentsapp.constants.URL
import com.koshake1.studentsapp.ui.adapters.OnVideoItemClickListener
import com.koshake1.studentsapp.ui.home.VideoOpener


class ClassesFragment : Fragment(), VideoOpener {

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
            classesAdapter = ClassesAdapter(list, FragmentType.CLASSES,
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
            Toast.makeText(context, "Can't open video app!", Toast.LENGTH_LONG).show()
        } catch (e : ActivityNotFoundException) {
            Toast.makeText(context, "Install Skype!", Toast.LENGTH_LONG).show()
        }
    }
}