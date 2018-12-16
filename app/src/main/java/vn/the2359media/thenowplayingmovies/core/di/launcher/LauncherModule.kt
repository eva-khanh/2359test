package vn.the2359media.thenowplayingmovies.core.di.launcher

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import dagger.Module
import dagger.Provides
import vn.the2359media.thenowplayingmovies.data.repository.ConfigurationRepository
import vn.the2359media.thenowplayingmovies.domain.Schedulers
import vn.the2359media.thenowplayingmovies.domain.interactor.impl.GetConfigUseCase
import vn.the2359media.thenowplayingmovies.presentation.launcher.LauncherViewModel

@Module
internal class LauncherModule {

    @Provides
    internal fun provideGetConfigurationUseCase(
        schedulers: Schedulers,
        getConfigurationRepository: ConfigurationRepository
    ): GetConfigUseCase = GetConfigUseCase(schedulers, getConfigurationRepository)

    @Provides
    internal fun provideViewModelFactory(
        context: Context,
        getConfigUseCase: GetConfigUseCase
    ): ViewModelProvider.Factory {
        return object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                return when {
                    modelClass.isAssignableFrom(LauncherViewModel::class.java) ->
                        LauncherViewModel(getConfigUseCase, context) as T
                    else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
                }
            }
        }
    }
}