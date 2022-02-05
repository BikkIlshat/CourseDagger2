package com.github.bikkilshat.coursedagger_2.di

import com.github.bikkilshat.coursedagger_2.network.ConnectionManager
import com.github.bikkilshat.coursedagger_2.network.NetworkUtils
import com.github.bikkilshat.coursedagger_2.network.ServerApi
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Qualifier


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


  /*
  Qualifier
Вместо только что рассмотренной нами аннотации @Named с текстовым значением мы можем создавать
свои аннотации. Для этого необходимо использовать Qualifier.
Создадим две аннотации: Prod и Dev:
   */
  @Qualifier
  @Retention(AnnotationRetention.RUNTIME)
  annotation class Prod

  @Qualifier
  @Retention(AnnotationRetention.RUNTIME)
  annotation class Dev
  /*
  Они так же, как и Named, помогут даггеру различать два способа создания объекта ServerApi.
  И мы, соответственно, используем одну из них, чтобы сказать компоненту, какой именно ServerApi нам нужен:
   */

  @Prod
  @Provides
  fun provideServerApiProd(): ServerApi {
    return ServerApi("prod.server.com") // объект  работает с prod сервером
  }

  @Dev
  @Provides
  fun provideServerApiDev(): ServerApi {
    return ServerApi("dev.server.com") // объект  работает с dev сервером
  }


}

/***
 * Аннотацией @Module мы сообщаем даггеру, что этот класс является модулем.
 * Аннотацией @Provides указывает, что метод является поставщиком объекта.
 */