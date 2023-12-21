package com.example.cleanarchitecturetraining.domain.usecase

import com.example.cleanarchitecturetraining.domain.models.SaveUserNameParam
import com.example.cleanarchitecturetraining.domain.models.UserName
import com.example.cleanarchitecturetraining.domain.repository.UserRepository

class SaveUserNameUsecase(private val userRepository : UserRepository) {

    fun execute(param: SaveUserNameParam) : Boolean {
        val oldUserName = userRepository.getName()

        if(oldUserName.firstName == param.name) return true
        val result = userRepository.saveName(param)
        return result
    }
}