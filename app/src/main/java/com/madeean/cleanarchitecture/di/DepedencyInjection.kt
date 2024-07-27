package com.madeean.cleanarchitecture.di

import com.madeean.cleanarchitecture.data.RepositoryImpl
import com.madeean.cleanarchitecture.domain.UseCaseImpl

object DepedencyInjection {
  private var repositoryInstance: RepositoryImpl? = null
  private var useCaseInstance: UseCaseImpl? = null

  @Synchronized
  fun getRepositoryInstance(): RepositoryImpl {
    if(repositoryInstance == null) {
      repositoryInstance = RepositoryImpl()
    }
    return repositoryInstance!!
  }

  @Synchronized
  fun getUseCaseInstance(): UseCaseImpl {
    if(useCaseInstance == null) {
      useCaseInstance = UseCaseImpl(getRepositoryInstance())
    }
    return useCaseInstance!!
  }
}