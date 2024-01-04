package com.example.melosphere.repository

import android.util.Log
import com.example.melosphere.api.UserAPI
import com.example.melosphere.models.UserRequest
import com.example.melosphere.models.UserRequestLogin
import com.example.melosphere.utils.Constants.TAG
import javax.inject.Inject

class UserRepository @Inject constructor(private val userAPI: UserAPI) {

    suspend fun registerUser(userRequest: UserRequest){
        val response = userAPI.signUp(userRequest)
        Log.d(TAG, response.body().toString())
    }

    suspend fun loginUser(userRequestLogin: UserRequestLogin){
        val response = userAPI.signIn(userRequestLogin)
        Log.d(TAG, response.body().toString())
    }
}