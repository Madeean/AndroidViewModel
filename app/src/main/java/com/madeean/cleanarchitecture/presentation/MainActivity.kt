package com.madeean.cleanarchitecture.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.madeean.cleanarchitecture.R
import com.madeean.cleanarchitecture.databinding.ActivityMainBinding
import com.madeean.cleanarchitecture.di.DepedencyInjection

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  private val viewModel: ViewModel by viewModels {
    Factory(DepedencyInjection.useCaseInstance)
  }
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    enableEdgeToEdge()
    setContentView(binding.root)
    setObserve()

    binding.btnGetData.setOnClickListener {
      viewModel.getData()
    }
  }

  private fun setObserve() {
    viewModel.data.observe(this){
      if (it.isNotBlank()) setUi(it)
    }
  }

  private fun setUi(data: String){
    binding.tvData.text = getString(R.string.data, data)
  }
}