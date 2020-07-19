package com.bibim.purpur.di

import com.bibim.purpur.data.repository.*
import org.koin.dsl.module

val repositoryAppModule = module {
    single { NameRepository(get()) }
    single { DetailRepository(get()) }
    single { QuizFragmentRepository(get()) }
    single { IslandRepository(get()) }
    single { IslandListRepository(get()) }
}