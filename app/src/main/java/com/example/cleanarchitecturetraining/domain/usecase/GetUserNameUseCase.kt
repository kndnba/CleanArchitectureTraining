package com.example.cleanarchitecturetraining.domain.usecase

import com.example.cleanarchitecturetraining.domain.models.UserName
import com.example.cleanarchitecturetraining.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute() : UserName {
        return userRepository.getName()
    }
}