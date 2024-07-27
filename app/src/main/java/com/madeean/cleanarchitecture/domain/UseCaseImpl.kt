package com.madeean.cleanarchitecture.domain

class UseCaseImpl(
  private val repository: Repository
): UseCase {
  override fun getData(): String {
    return repository.getData()
  }
}