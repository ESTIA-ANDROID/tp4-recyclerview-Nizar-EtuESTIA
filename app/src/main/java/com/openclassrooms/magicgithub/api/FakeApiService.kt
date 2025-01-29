package com.openclassrooms.magicgithub.api

import com.openclassrooms.magicgithub.model.User

class FakeApiService : ApiService {

    // Keep a reference to the mutable list of fake users
    private val _users = FakeApiServiceGenerator.FAKE_USERS

    override fun getUsers(): List<User> {
        // Return the existing list
        return _users
    }

    override fun addRandomUser() {
        // Pick a random user from FAKE_USERS_RANDOM and add it to _users
        val randomUser = FakeApiServiceGenerator.FAKE_USERS_RANDOM.random()
        _users.add(randomUser)
    }

    override fun deleteUser(user: User) {
        // Remove the user from _users
        _users.remove(user)
    }
}