package com.example.melosphere

import android.graphics.Color
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.melosphere.databinding.FragmentSignUpBinding

class SignUpFragment : Fragment() {
    private var _binding : FragmentSignUpBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        val next = binding.nextToPassword
        val activity = activity as LoginActivity
        val back = binding.backSignUp
        next.setOnClickListener {
            val email = binding.SignUpemailInput.text.toString()
            if(email.isEmpty()){
                binding.emailStatement.setText("Please provide a valid Email.").toString()
                binding.emailStatement.setTextColor(Color.RED)
            }else if(email.length < 5){
                binding.emailStatement.setText("Please provide a valid Email.").toString()
                binding.emailStatement.setTextColor(Color.RED)
            }else if(email.substring(email.length - 4).compareTo(".com") != 0 || !email.contains("@")
                || email.contains(' ')) {
                binding.emailStatement.setText("Please provide a valid Email.").toString()
                binding.emailStatement.setTextColor(Color.RED)
            }else{
                activity.Email = email
                findNavController().navigate(R.id.action_signUpFragment_to_passwordFragment)
            }
        }

        back.setOnClickListener {
            activity.Email = ""
            findNavController().popBackStack()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null;
    }
}