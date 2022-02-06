package com.github.bikkilshat.coursedagger_2.di

import com.github.bikkilshat.coursedagger_2.intoSet.EventHandler
import com.github.bikkilshat.coursedagger_2.storage.DatabaseHelper
import com.github.bikkilshat.coursedagger_2.storage.Repository
import dagger.Module
import dagger.Provides
import dagger.multibindings.ElementsIntoSet

/***
 * Модули
Создаем модули, которые будут уметь предоставлять требуемые объекты.
Именно в модулях мы и пишем весь код по созданию объектов. Это обычные классы, но с парой аннотаций.
 */

@Module
class StorageModule {

  //В модуле создали Provides метод для создания объекта Repository
  @Provides
  fun provideRepository(): Repository {
    return Repository()
  }

}

/***
 * Аннотацией @Module мы сообщаем даггеру, что этот класс является модулем.
 * Аннотацией @Provides указывает, что метод является поставщиком объекта.
 */