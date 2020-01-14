package com.eferraz.shufflesongs

import com.eferraz.shufflesongs.infra.KoinModuleDefinition
import com.eferraz.shufflesongs.infra.TestKoinModuleDefinition
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TestAppApplication : AppApplication() {

    override fun configureDI() {
        startKoin {
            androidContext(this@TestAppApplication)
            modules(
                listOf(
                    KoinModuleDefinition.vm,
                    TestKoinModuleDefinition.business
                )
            )
        }
    }
}