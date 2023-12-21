package com.example.cleanarchitecturetraining.domain.repository

import com.example.cleanarchitecturetraining.domain.models.SaveUserNameParam
import com.example.cleanarchitecturetraining.domain.models.UserName

interface UserRepository {

    fun saveName(saveParam: SaveUserNameParam) : Boolean

    fun getName() : UserName
}
