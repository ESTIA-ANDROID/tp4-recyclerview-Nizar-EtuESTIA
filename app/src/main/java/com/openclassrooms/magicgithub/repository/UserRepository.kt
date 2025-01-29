package com.openclassrooms.magicgithub.repository

import com.openclassrooms.magicgithub.api.ApiService
import com.openclassrooms.magicgithub.model.User

class UserRepository(
    private val apiService: ApiService
) {

    fun getUsers(): List<User> {
        // Simply delegate to the ApiService
        return apiService.getUsers()
    }

    fun addRandomUser() {
        // Simply delegate to the ApiService
        apiService.addRandomUser()
    }

    fun deleteUser(user: User) {
        // Simply delegate to the ApiService
        apiService.deleteUser(user)
    }
}