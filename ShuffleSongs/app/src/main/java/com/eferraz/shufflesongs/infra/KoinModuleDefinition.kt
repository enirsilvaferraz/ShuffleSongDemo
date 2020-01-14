package com.eferraz.shufflesongs.infra

import androidx.room.Room
import com.eferraz.shufflesongs.business.*
import com.eferraz.shufflesongs.data.AppDataBase
import com.eferraz.shufflesongs.view.ShuffleSongViewModel
import com.google.gson.GsonBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object KoinModuleDefinition {

    val infra = module {
        factory {
            Retrofit.Builder()
                .baseUrl(ConfigurationConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .build().create(ApiService::class.java)
        }

        factory {
            Room.databaseBuilder(androidContext(), AppDataBase::class.java, "database").build()
        }

        factory { NetworkUtil(androidContext()) }
    }

    val repository = module {
        factory { SongRepositoryRemoteImpl(api = get()) }
        factory { SongRepositoryLocalImpl(db = get()) }
    }

    val business = module {
        factory {
            ShuffleBusinessImpl(
                remoteRep = get(),
                localRep = get(),
                network = get()
            ) as ShuffleBusiness
        }
    }

    val vm = module {
        viewModel { ShuffleSongViewModel(business = get()) }
    }
}
