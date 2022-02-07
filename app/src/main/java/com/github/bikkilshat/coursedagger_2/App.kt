package com.github.bikkilshat.coursedagger_2

import android.app.Application
import com.github.bikkilshat.coursedagger_2.di.AppComponent
import com.github.bikkilshat.coursedagger_2.di.AppModule
import com.github.bikkilshat.coursedagger_2.di.DaggerAppComponent


/***
 *  Этот класс  будет создавать объекты и возвращать их нам.
 */

class App: Application() {

  lateinit var appComponent: AppComponent

  override fun onCreate() {
    super.onCreate()
    appComponent = DaggerAppComponent
      .builder() //Метод builder() теперь возвращает наш кастомный билдер.
      .context(this) //Код вызывается в Application классе, поэтому this - это Context
      .buildAppComp() //И мы вызываем у него метод buildAppComp, чтобы получить компонент.
  }
}