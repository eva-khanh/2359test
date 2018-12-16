package vn.the2359media.thenowplayingmovies.core.di

import android.content.Context
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import vn.the2359media.thenowplayingmovies.BuildConfig
import vn.the2359media.thenowplayingmovies.MovieApplication
import vn.the2359media.thenowplayingmovies.R
import vn.the2359media.thenowplayingmovies.core.PreferenceHelper
import vn.the2359media.thenowplayingmovies.domain.AppScheduler
import vn.the2359media.thenowplayingmovies.domain.Schedulers
import vn.the2359media.thenowplayingmovies.presentation.ConfigChecker
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    internal fun provideApplicationContext(application: MovieApplication): Context = application.applicationContext

    @Provides
    @Singleton
    internal fun provideRetrofit(context: Context): Retrofit {
        return Retrofit.Builder()
            .baseUrl(context.getString(R.string.api_base_url))
            .client(createClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun createClient(): OkHttpClient {
        val okHttpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC)
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }
        return okHttpClientBuilder.build()
    }

    @Provides
    @Singleton
    internal fun provideSchedulers(): Schedulers = AppScheduler()

    @Provides
    @Singleton
    internal fun providePreferenceHelper(context: Context): PreferenceHelper = PreferenceHelper(context)

    @Provides
    @Singleton
    internal fun provideConfigChecker(preferenceHelper: PreferenceHelper) = ConfigChecker(preferenceHelper)


}