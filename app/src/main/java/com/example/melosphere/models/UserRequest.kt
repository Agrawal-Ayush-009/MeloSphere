package com.example.melosphere.models

data class UserRequest(
    val dob: String,
    val email: String,
    val gender: String,
    val name: String,
    val password: String,
    val username: String
)