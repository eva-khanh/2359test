package vn.the2359media.thenowplayingmovies.core.di

import android.app.LauncherActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.the2359media.thenowplayingmovies.presentation.home.HomeActivity

@Module
internal abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun contributeLauncherActivityInjector(): LauncherActivity

    @ContributesAndroidInjector
    internal abstract fun contributeHomeActivityInjector(): HomeActivity
}