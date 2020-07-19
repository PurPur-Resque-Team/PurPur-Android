package com.bibim.purpur.di

import com.bibim.purpur.data.repository.DetailRepository
import com.bibim.purpur.data.repository.IslandRepository
import com.bibim.purpur.data.repository.NameRepository
import org.koin.dsl.module

val repositoryAppModule = module {
    single { NameRepository(get()) }
    single { DetailRepository(get()) }
    single { IslandRepository(get()) }
}