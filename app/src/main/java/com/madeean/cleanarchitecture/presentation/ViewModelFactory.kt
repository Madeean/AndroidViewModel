package com.madeean.cleanarchitecture.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.madeean.cleanarchitecture.domain.UseCase

@Suppress("UNCHECKED_CAST")
class Factory (
  private val useCase: UseCase
): ViewModelProvider.NewInstanceFactory() {

  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    return when {
      modelClass.isAssignableFrom(com.madeean.cleanarchitecture.presentation.ViewModel::class.java) -> ViewModel(
        useCase
      ) as T
      else -> throw IllegalArgumentException("Unknown ViewModel class: "+modelClass.name)
    }
  }
}