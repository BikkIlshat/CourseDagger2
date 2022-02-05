package com.github.bikkilshat.coursedagger_2.di

import android.app.Application
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