package com.eferraz.shufflesongs

import android.app.Application
import com.eferraz.shufflesongs.infra.KoinModuleDefinition.business
import com.eferraz.shufflesongs.infra.KoinModuleDefinition.infra
import com.eferraz.shufflesongs.infra.KoinModuleDefinition.repository
import com.eferraz.shufflesongs.infra.KoinModuleDefinition.vm
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class AppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        configureDI()
    }

    open fun configureDI() {
        startKoin {
            androidContext(this@AppApplication)
            modules(listOf(vm, business, repository, infra))
        }
    }
}