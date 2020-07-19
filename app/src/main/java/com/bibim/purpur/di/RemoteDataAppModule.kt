package com.bibim.purpur.di

import com.bibim.purpur.data.remote.RemoteDataSource
import com.bibim.purpur.data.remote.RemoteDataSourceImpl
import org.koin.dsl.module

val remoteDataSourceAppModule = module { single<RemoteDataSource> { RemoteDataSourceImpl() } }