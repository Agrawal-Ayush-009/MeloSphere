package com.example.melosphere

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.melosphere.databinding.FragmentGenderBinding

class GenderFragment : Fragment() {
    private var _binding: FragmentGenderBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGenderBinding.inflate(inflater, container, false)
        val female = binding.female
        val male = binding.male
        val nonBinary = binding.nonBinary
        val other = binding.other
        val notSay = binding.notSay
        val activity = activity as LoginActivity
        val back = binding.backGender
        female.setOnClickListener {
            activity.gender = "Female"
            findNavController().navigate(R.id.action_genderFragment_to_finalSignupFragment)
        }

        male.setOnClickListener {
            activity.gender = "Male"
            findNavController().navigate(R.id.action_genderFragment_to_finalSignupFragment)

        }

        nonBinary.setOnClickListener {
            activity.gender = "Non-Binary"
            findNavController().navigate(R.id.action_genderFragment_to_finalSignupFragment)
        }

        other.setOnClickListener {
            activity.gender = "Other"
            findNavController().navigate(R.id.action_genderFragment_to_finalSignupFragment)
        }


        notSay.setOnClickListener {
            activity.gender = "Not Available"
            findNavController().navigate(R.id.action_genderFragment_to_finalSignupFragment)
        }

        back.setOnClickListener {
            activity.gender = ""
            findNavController().popBackStack()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}