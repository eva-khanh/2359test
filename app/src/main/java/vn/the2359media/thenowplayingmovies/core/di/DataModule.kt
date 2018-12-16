package vn.the2359media.thenowplayingmovies.core.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import vn.the2359media.thenowplayingmovies.core.PreferenceHelper
import vn.the2359media.thenowplayingmovies.data.repository.ConfigurationRepository
import vn.the2359media.thenowplayingmovies.data.repository.NowPlayingRepository
import vn.the2359media.thenowplayingmovies.data.source.ConfigurationRemoteDataSource
import vn.the2359media.thenowplayingmovies.data.source.NowPlayingRemoteDataSource
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provieConfigurationRemoteDataSource(retrofit: Retrofit) = ConfigurationRemoteDataSource(retrofit)

    @Provides
    @Singleton
    fun provideNowPlayingRemoteDataSource(retrofit: Retrofit) = NowPlayingRemoteDataSource(retrofit)

    @Provides
    @Singleton
    fun provideConfigurationRepository(configurationRemoteDataSource: ConfigurationRemoteDataSource, preferenceHelper: PreferenceHelper) = ConfigurationRepository(configurationRemoteDataSource, preferenceHelper)

    @Provides
    @Singleton
    fun provideNowPlayingRepository(nowPlayingRemoteDataSource: NowPlayingRemoteDataSource) = NowPlayingRepository(nowPlayingRemoteDataSource)
}