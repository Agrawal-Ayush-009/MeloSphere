package com.example.melosphere

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.melosphere.databinding.FragmentPhoneBinding
import com.hbb20.CountryCodePicker

class PhoneFragment : Fragment() {
    private var _binding : FragmentPhoneBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPhoneBinding.inflate(inflater, container, false)

        val next = binding.nextToOTP
        val codePicker = binding.countryCode
        val activity = activity as LoginActivity
        val back = binding.backPhone
        next.setOnClickListener {
            val code = codePicker.selectedCountryCode
            val number = binding.number.text.toString()
            if(number.isEmpty()){
                binding.numberWarning.setText("Please enter a valid number").toString()
                binding.numberWarning.setTextColor(Color.RED)
            }else if(number.length < 10){
                binding.numberWarning.setText("Please enter a valid number").toString()
                binding.numberWarning.setTextColor(Color.RED)
            }else{
                activity.phone = "+$code$number"
                activity.Email = ""
                Toast.makeText(activity, "Sent OTP to ${activity.phone}", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_phoneFragment_to_OTPFragment)
            }
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