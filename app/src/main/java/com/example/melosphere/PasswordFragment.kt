package com.example.melosphere

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.melosphere.databinding.FragmentEmailLoginBinding
import com.example.melosphere.databinding.FragmentPasswordBinding
import com.example.melosphere.databinding.FragmentSignUpBinding

class PasswordFragment : Fragment() {
    private var _binding: FragmentPasswordBinding? = null
    private val binding get() =  _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPasswordBinding.inflate(inflater, container, false)
        val next = binding.nextToDOB
        val activity = activity as LoginActivity
        val back = binding.backPassword
        next.setOnClickListener {
            val password = binding.SignUPpasswordInput.text.toString()
            if(password.isEmpty()){
                binding.passwordWarning.setText("Use at least 8 characters").toString()
                binding.passwordWarning.setTextColor(Color.RED)
            }else if(password.length < 8){
                binding.passwordWarning.setText("Use at least 8 characters").toString()
                binding.passwordWarning.setTextColor(Color.RED)
            }else if(password.contains(" ")){
                binding.passwordWarning.setText("Enter a valid password!").toString()
                binding.passwordWarning.setTextColor(Color.RED)
            }else{
                activity.password = password
                findNavController().navigate(R.id.action_passwordFragment_to_DOBFragment)
            }
        }

        back.setOnClickListener {
            activity.password = ""
            findNavController().popBackStack()
        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null;
    }
}