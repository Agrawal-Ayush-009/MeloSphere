package com.example.melosphere

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.melosphere.models.UserRequest
import com.example.melosphere.models.UserRequestLogin
import com.example.melosphere.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val userRepository: UserRepository): ViewModel() {

    fun registerUser(userRequest: UserRequest){
        viewModelScope.launch{
            userRepository.registerUser(userRequest)
        }
    }

    fun loginUser(userRequestLogin: UserRequestLogin){
        viewModelScope.launch{
            userRepository.loginUser(userRequestLogin)
        }
    }
}