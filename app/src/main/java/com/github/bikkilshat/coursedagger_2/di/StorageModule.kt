package com.github.bikkilshat.coursedagger_2.di

import android.content.Context
import com.github.bikkilshat.coursedagger_2.storage.Repository
import dagger.Module
import dagger.Provides

/***
 * Модули
Создаем модули, которые будут уметь предоставлять требуемые объекты.
Именно в модулях мы и пишем весь код по созданию объектов. Это обычные классы, но с парой аннотаций.
 */

@Module
class StorageModule {

  //В модуле создали Provides метод для создания объекта Repository
  @Provides
  fun provideRepository(context: Context): Repository {
    return Repository(context)
  }


  /***
   * Аннотацией @Module мы сообщаем даггеру, что этот класс является модулем.
   * Аннотацией @Provides указывает, что метод является поставщиком объекта.
   */

}