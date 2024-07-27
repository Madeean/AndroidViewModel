package com.madeean.cleanarchitecture.data

import com.madeean.cleanarchitecture.domain.Repository

class RepositoryImpl: Repository {
  override fun getData(): String {
    return "Hello World"
  }
}