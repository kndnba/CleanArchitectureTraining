package com.example.cleanarchitecturetraining.data.storage

import com.example.cleanarchitecturetraining.data.storage.models.User

interface UserStorage {
    fun save(user: User) : Boolean
    fun get() : User
}
