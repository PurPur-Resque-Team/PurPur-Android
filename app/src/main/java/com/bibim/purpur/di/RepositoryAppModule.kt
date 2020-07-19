package com.bibim.purpur.di

import com.bibim.purpur.data.repository.DetailRepository
import com.bibim.purpur.data.repository.NameRepository
import com.bibim.purpur.data.repository.QuizFragmentRepository
import org.koin.dsl.module

val repositoryAppModule = module {
    single { NameRepository(get()) }
    single { DetailRepository(get()) }
    single { QuizFragmentRepository(get()) }
}