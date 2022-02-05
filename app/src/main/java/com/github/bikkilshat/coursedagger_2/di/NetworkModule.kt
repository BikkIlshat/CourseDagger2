package com.github.bikkilshat.coursedagger_2.di

import com.github.bikkilshat.coursedagger_2.network.ConnectionManager
import com.github.bikkilshat.coursedagger_2.network.NetworkUtils
import com.github.bikkilshat.coursedagger_2.network.ServerApi
import dagger.Module
import dagger.Provides
import javax.inject.Named


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

  //Пример с Named
  //Создаем два разных ServerApi в модуле даггера:
  @Named("prod")
  @Provides
  fun provideServerApiProd(): ServerApi {
    return ServerApi("prod.server.com") // объект  работает с prod сервером
  }

  @Named("dev")
  @Provides
  fun provideServerApiDev(): ServerApi {
    return ServerApi("dev.server.com") // объект  работает с dev сервером
  }
  //Прописываем в компоненте метод для получения ServerApi
  /*
  Теперь даггер может отличить эти объекты.
   А мы сможем указать, какой из них нам нужен. Для этого мы также используем Named в компоненте:
   */


}

/***
 * Аннотацией @Module мы сообщаем даггеру, что этот класс является модулем.
 * Аннотацией @Provides указывает, что метод является поставщиком объекта.
 */