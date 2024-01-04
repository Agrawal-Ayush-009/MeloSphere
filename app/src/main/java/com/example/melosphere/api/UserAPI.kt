package com.example.melosphere.api


import com.example.melosphere.models.UserRequest
import com.example.melosphere.models.UserRequestLogin
import com.example.melosphere.models.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {


    @POST("/user/register")
    fun signUp(@Body userRequest: UserRequest): Response<UserResponse>


    @POST("/user/login")
    fun signIn(@Body userRequestLogin: UserRequestLogin): Response<UserResponse>

}