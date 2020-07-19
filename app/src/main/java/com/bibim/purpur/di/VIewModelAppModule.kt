package com.bibim.purpur.di

import com.bibim.purpur.ui.detail.main.DetailViewModel
import com.bibim.purpur.ui.name.NameViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelAppModule = module {

    viewModel { DetailViewModel(get()) }
    viewModel<NameViewModel> { NameViewModel(get()) }
}