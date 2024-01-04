package com.example.melosphere

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.melosphere.databinding.FragmentDOBBinding
import java.time.Year
import java.util.Calendar

class DOBFragment : Fragment() {
    private var _binding : FragmentDOBBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDOBBinding.inflate(inflater, container, false)
        val next = binding.nextToGender
        val back = binding.backDOB
        val activity = activity as LoginActivity
        next.setOnClickListener {
            val datePicker = binding.datePicker
            val day = datePicker.dayOfMonth
            val month = datePicker.month+1
            val year = datePicker.year

            activity.DOB = "$day/$month/$year"
            findNavController().navigate(R.id.action_DOBFragment_to_genderFragment)
        }

        back.setOnClickListener {
            activity.DOB = ""
            findNavController().popBackStack()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}