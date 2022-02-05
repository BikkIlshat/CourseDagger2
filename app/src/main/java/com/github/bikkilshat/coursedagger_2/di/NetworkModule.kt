package com.github.bikkilshat.coursedagger_2.di

import com.github.bikkilshat.coursedagger_2.NetworkUtils
import dagger.Module
import dagger.Provides

/***
 * Модули
Создаем модули, которые будут уметь предоставлять требуемые объекты.
Именно в модулях мы и пишем весь код по созданию объектов. Это обычные классы, но с парой аннотаций.
 */

@Module
class NetworkModule {

  @Provides
  fun provideNetworkUtils(): NetworkUtils {
    return NetworkUtils()
  }

}

/***
 * Аннотацией @Module мы сообщаем даггеру, что этот класс является модулем.
 * Аннотацией @Provides указывает, что метод является поставщиком объекта.
 */