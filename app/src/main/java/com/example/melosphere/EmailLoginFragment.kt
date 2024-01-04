package com.example.melosphere

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.melosphere.databinding.FragmentEmailLoginBinding
import com.example.melosphere.models.UserRequest
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EmailLoginFragment : Fragment() {
    private var _binding: FragmentEmailLoginBinding? = null
    private val binding get() =  _binding!!
    private val authViewModel by viewModels<AuthViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEmailLoginBinding.inflate(inflater, container, false)
        val loginButton = binding.EmailLoginButton
        val back = binding.backSignIn
        loginButton.setOnClickListener {
//            val email = binding.SigninemailInput.text.toString()
//            val password = binding.SigninpasswordInput.text.toString()
            authViewModel.registerUser(UserRequest("2002-10-09", "ashley@gmail.com" , "male", "Ayush"
            ,"king","ashkinggt"))
//            if(password.isEmpty()){
//                binding.passwordStatement.setText("Password cannot be empty.").toString()
//                binding.passwordStatement.setTextColor(Color.RED)
//            }
//            if(email.isEmpty()){
//                binding.emailStatement.setText("Please provide a valid Email.").toString()
//                binding.emailStatement.setTextColor(Color.RED)
//            }else if(email.length < 5){
//                binding.emailStatement.setText("Please provide a valid Email.").toString()
//                binding.emailStatement.setTextColor(Color.RED)
//            }else if(email.substring(email.length - 4).compareTo(".com") != 0 || !email.contains("@")
//                || email.contains(' ')) {
//                binding.emailStatement.setText("Please provide a valid Email.").toString()
//                binding.emailStatement.setTextColor(Color.RED)
//            }else{
//                startActivity(Intent(activity, MainActivity::class.java))
//                activity?.finish()
//            }

        }

        back.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null;
    }

}