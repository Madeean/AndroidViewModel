package com.madeean.cleanarchitecture.di

import com.madeean.cleanarchitecture.data.RepositoryImpl
import com.madeean.cleanarchitecture.domain.UseCaseImpl

object DepedencyInjection {
  private var repositoryInstance: RepositoryImpl = RepositoryImpl()
  var useCaseInstance: UseCaseImpl = UseCaseImpl(repositoryInstance)
}