package com.github.bikkilshat.coursedagger_2

import android.app.Application
import com.github.bikkilshat.coursedagger_2.di.AppComponent
import com.github.bikkilshat.coursedagger_2.di.DaggerAppComponent


/***
 *  Этот класс  будет создавать объекты и возвращать их нам.
 */

class App: Application() {

  lateinit var appComponent: AppComponent

  override fun onCreate() {
    super.onCreate()
    appComponent = DaggerAppComponent.create()
  }
}