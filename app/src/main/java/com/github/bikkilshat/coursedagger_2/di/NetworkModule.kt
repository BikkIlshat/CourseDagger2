package com.github.bikkilshat.coursedagger_2.di

import com.github.bikkilshat.coursedagger_2.network.ConnectionManager
import com.github.bikkilshat.coursedagger_2.network.NetworkUtils
import dagger.Module
import dagger.Provides


/***
 * Модули
Создаем модули, которые будут уметь предоставлять требуемые объекты.
Именно в модулях мы и пишем весь код по созданию объектов. Это обычные классы, но с парой аннотаций.
 */

@Module
class NetworkModule {

  // В модуле создали Provides метод для создания объекта ConnectionManager
  @Provides
  fun provideConnectionManager(): ConnectionManager {
    return ConnectionManager()
  }

  // Добавили ConnectionManager как аргумент в Provides метод создания NetworkUtils:
  @Provides
  fun provideNetworkUtils(connectionManager: ConnectionManager): NetworkUtils {
    return NetworkUtils(connectionManager)
  }

}

/***
 * Аннотацией @Module мы сообщаем даггеру, что этот класс является модулем.
 * Аннотацией @Provides указывает, что метод является поставщиком объекта.
 */