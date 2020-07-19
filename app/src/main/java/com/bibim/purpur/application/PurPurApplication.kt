package com.bibim.purpur.application

import android.app.Application
import com.bibim.purpur.di.remoteDataSourceAppModule
import com.bibim.purpur.di.repositoryAppModule
import com.bibim.purpur.di.viewModelAppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PurPurApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidContext(this@PurPurApplication)
            modules(
                listOf(
                    repositoryAppModule,remoteDataSourceAppModule, viewModelAppModule
                )
            )
        }
    }
}