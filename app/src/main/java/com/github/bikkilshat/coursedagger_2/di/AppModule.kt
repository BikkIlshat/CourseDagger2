package com.github.bikkilshat.coursedagger_2.di

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.content.res.Resources
import dagger.Module
import dagger.Provides

/*
Передача объекта
Один из самых распространенных примеров - это передача Context.
Например, мы хотим, чтобы компонент мог давать нам такие объекты,
как SharedPreferences или Resources. Для этого мы создаем модуль AppModule:
 */
@Module
class AppModule(private val context: Context) {

  @Provides
  fun getPreferences(): SharedPreferences {
    return context.getSharedPreferences("prefs", MODE_PRIVATE)
  }

  @Provides
  fun getResources(): Resources {
    return context.resources
  }

  @Provides
  fun getAppContext(): Context {
    return context
  }
  /*
  Но есть проблема. Нам нужен Context. Даггер сам создать его не может.
   Да и мы не сможем написать такой Provides метод, который предоставит даггеру Context.
    Для таких случаев есть возможность передать Context модулю в конструктор.
    class AppModule (private val context: Context)

    Теперь все в порядке с точки зрения модуля.
    У него есть context, и он сможет его использовать в Provides методах.
   */
}