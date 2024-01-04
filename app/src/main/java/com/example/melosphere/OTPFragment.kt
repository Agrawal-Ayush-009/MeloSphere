package com.example.melosphere

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.melosphere.databinding.FragmentDOBBinding
import com.example.melosphere.databinding.FragmentOTPBinding

class OTPFragment : Fragment() {
    private var _binding:FragmentOTPBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOTPBinding.inflate(inflater,container, false)

        val editPhoneNUmber = binding.EditPhoneNumber
        val next = binding.next
        val back = binding.backOTP
        editPhoneNUmber.setOnClickListener {
            findNavController().popBackStack()
        }
        next.setOnClickListener {
            findNavController().navigate(R.id.action_OTPFragment_to_DOBFragment)
        }

        back.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}