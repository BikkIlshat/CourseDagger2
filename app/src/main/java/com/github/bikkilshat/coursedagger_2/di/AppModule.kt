package com.github.bikkilshat.coursedagger_2.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.content.res.Resources
import dagger.Module
import dagger.Provides


@Module(subcomponents = [MainComponent::class])
class AppModule {

  @Provides
  fun getPreferences(context: Context): SharedPreferences {
    return context.getSharedPreferences("prefs", MODE_PRIVATE)
  }

  @Provides
  fun getResources(context: Context): Resources {
    return context.resources
  }


}