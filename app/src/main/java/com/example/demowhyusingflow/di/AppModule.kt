package com.example.demowhyusingflow.di

import org.koin.core.module.Module

val appModules : List<Lazy<Module>> = buildList {
    add(viewModelModule)
}