package com.madeean.cleanarchitecture.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.madeean.cleanarchitecture.R
import com.madeean.cleanarchitecture.databinding.ActivityMainBinding
import com.madeean.cleanarchitecture.di.DepedencyInjection
import com.madeean.cleanarchitecture.domain.UseCase

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  private val useCase: UseCase = DepedencyInjection.getUseCaseInstance()
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    enableEdgeToEdge()
    setContentView(binding.root)

    binding.btnGetData.setOnClickListener {
      setUi(useCase.getData())
    }
  }

  private fun setUi(data: String){
    binding.tvData.text = getString(R.string.data, data)
  }
}