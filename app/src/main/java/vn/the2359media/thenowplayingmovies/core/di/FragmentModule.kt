package vn.the2359media.thenowplayingmovies.core.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import vn.the2359media.thenowplayingmovies.core.di.home.HomeModule
import vn.the2359media.thenowplayingmovies.core.di.launcher.LauncherModule
import vn.the2359media.thenowplayingmovies.presentation.home.HomeFragment
import vn.the2359media.thenowplayingmovies.presentation.launcher.LauncherFragment

@Module
abstract class FragmentModule {


    @ContributesAndroidInjector(modules = [LauncherModule::class])
    internal abstract fun contributeLauncherFragment(): LauncherFragment

    @ContributesAndroidInjector(modules = [HomeModule::class])
    internal abstract fun contributeHomeFragment(): HomeFragment
}