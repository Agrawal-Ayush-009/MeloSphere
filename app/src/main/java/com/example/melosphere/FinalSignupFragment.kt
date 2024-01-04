package com.example.melosphere

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.melosphere.databinding.FragmentFinalSignupBinding
import com.example.melosphere.databinding.FragmentSignUpBinding
import java.security.PrivateKey
import java.util.Calendar

class FinalSignupFragment : Fragment() {
    private var _binding: FragmentFinalSignupBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFinalSignupBinding.inflate(inflater, container, false)

        val activity = activity as LoginActivity
        val email = activity.Email
        val dob = activity.DOB
        val gender = activity.gender
        val back = binding.backFinal
        if(email.isEmpty()){
           binding.nameInput.setText(activity.phone).toString()
        }else{
            val idx = email.indexOf("@")
            val userName = email.substring(0, idx)
            binding.usernameInput.setText(userName).toString()
        }
        binding.GenderInput.setText(gender).toString()
        binding.DOBInput.setText(dob).toString()
        binding.DOBInput.setOnClickListener{
            val c = Calendar.getInstance()

            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                activity,
                { view, year, monthOfYear, dayOfMonth ->
                    val dat = (dayOfMonth.toString() + "/" + (monthOfYear + 1) + "/" + year)
                    binding.DOBInput.setText(dat)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()
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