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
  /*
  В Qualifier аннотации, которые мы создаем, мы можем добавлять аргументы. Например,
  у нас есть два Prod сервера: prod1.server.com и prod2.server.com.
  И мы хотим под каждый из них создавать свой ServerApi.
  Можно конечно создать аннотации Prod1 и Prod2. А можно использовать одну аннотацию Prod, но с аргументом.

Добавляем String аргумент к аннотации Prod:
   */
  @Qualifier
  @Retention(AnnotationRetention.RUNTIME)
  annotation class Prod (val value: String = "") // Добавляем String аргумент к аннотации Prod:

  @Qualifier
  @Retention(AnnotationRetention.RUNTIME)
  annotation class Dev

/*
И используем для создания двух разных объектов ServerApi:
 */
  @Prod("1")
  @Provides
  fun provideServerApiProd1(): ServerApi {
    return ServerApi("prod1.server.com") // объект  работает с prod сервером
  }

  @Prod("2")
  @Provides
  fun provideServerApiProd2(): ServerApi {
    return ServerApi("prod2.server.com") // объект  работает с prod сервером
  }
  

}

/***
 * Аннотацией @Module мы сообщаем даггеру, что этот класс является модулем.
 * Аннотацией @Provides указывает, что метод является поставщиком объекта.
 */