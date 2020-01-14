package com.eferraz.shufflesongs.infra

import com.eferraz.shufflesongs.business.ShuffleBusiness
import com.eferraz.shufflesongs.business.ShuffleBusinessMock
import org.koin.dsl.module

object TestKoinModuleDefinition {

    val business = module {
        factory { ShuffleBusinessMock() as ShuffleBusiness }
    }
}