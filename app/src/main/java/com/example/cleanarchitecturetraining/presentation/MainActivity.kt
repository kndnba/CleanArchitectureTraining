package com.example.cleanarchitecturetraining.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cleanarchitecturetraining.data.repository.UserRepositoryImpl
import com.example.cleanarchitecturetraining.data.storage.sharedPrefs.SharedPrefUserStorage
import com.example.cleanarchitecturetraining.databinding.ActivityMainBinding
import com.example.cleanarchitecturetraining.domain.models.SaveUserNameParam
import com.example.cleanarchitecturetraining.domain.models.UserName
import com.example.cleanarchitecturetraining.domain.usecase.GetUserNameUseCase
import com.example.cleanarchitecturetraining.domain.usecase.SaveUserNameUsecase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val userRepository by lazy {
        UserRepositoryImpl(SharedPrefUserStorage(applicationContext))
    }

    private val getUserNameUseCase by lazy {
        GetUserNameUseCase(userRepository)
    }

    private val saveUserNameUseCase by lazy {
        SaveUserNameUsecase(userRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            sendButton.setOnClickListener {
                var name = dataEditText.text.toString()
                var lastName = dataEditTextLastName.text.toString()
                val param = SaveUserNameParam(
                    name = name,
                    lastName = lastName
                )
                val result = saveUserNameUseCase.execute(param = param)
                dataTextView.text = "Saved result = $result"
            }

            receiveButton.setOnClickListener {
                val userName: UserName = getUserNameUseCase.execute()
                dataTextView.text = "${userName.firstName} ${userName.lastName}"
            }
        }
    }
}
