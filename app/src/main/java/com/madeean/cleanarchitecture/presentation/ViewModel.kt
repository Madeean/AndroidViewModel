package com.madeean.cleanarchitecture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.madeean.cleanarchitecture.domain.UseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class ViewModel(private val useCase: UseCase): ViewModel() {
  private val _data: MutableLiveData<String> = MutableLiveData()
  val data: LiveData<String> = _data

  fun getData() {
    viewModelScope.launch {
      _data.value = useCase.getData()
    }
  }
}