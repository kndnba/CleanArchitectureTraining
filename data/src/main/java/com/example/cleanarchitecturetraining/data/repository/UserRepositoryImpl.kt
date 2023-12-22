package com.example.cleanarchitecturetraining.data.repository

import com.example.cleanarchitecturetraining.data.storage.models.User
import com.example.cleanarchitecturetraining.data.storage.UserStorage
import com.example.cleanarchitecturetraining.domain.models.SaveUserNameParam
import com.example.cleanarchitecturetraining.domain.models.UserName
import com.example.cleanarchitecturetraining.domain.repository.UserRepository

class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam) : Boolean {
        val user = User(firstName = saveParam.name, lastName = saveParam.lastName)
        return userStorage.save(user)
    }

    override fun getName(): UserName {
        val user = userStorage.get()
        return UserName(firstName = user.firstName, lastName = user.lastName)
    }
}
