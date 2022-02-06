package com.github.bikkilshat.coursedagger_2.elementsIntoSet

import com.github.bikkilshat.coursedagger_2.storage.DatabaseHelper
import dagger.Module
import dagger.Provides
import dagger.multibindings.ElementsIntoSet


/**
 * ElementsIntoSet
Эта аннотация работает примерно так же, как и IntoSet, но добавляет в коллекцию не один элемент, а коллекцию элементов.
 */

class Event {}

/*
Мы хотим пропускать его через несколько обработчиков EventHandlerElementsIntoSet:
 */
interface EventHandlerElementsIntoSet {
  fun handle(event: Event)

}

/*
Такими обработчиками могут быть, например, аналитика и логи:
 */
class Analytics : EventHandlerElementsIntoSet {
  override fun handle(event: Event) {
    // ...
  }

}

class Logger : EventHandlerElementsIntoSet {
  override fun handle(event: Event) {
    // ...
  }

}


@Module
class EvenModuleElementsIntoSet {
  /*
  Мы хотим добавить эти обработчики к общему списку, где уже есть Analytics и Logger.
  Для этого используем ElementsIntoSet с методом @Provides:
   */
  @ElementsIntoSet
  @Provides
  fun provideDatabaseEventHandlers(databaseHelper: DatabaseHelper): Set<EventHandlerElementsIntoSet> {
    return databaseHelper.getEventHandlers()
  }


}
/*
Обратите внимание, что тип возвращаемого значения у этих методов - EventHandlerElementsIntoSet.
Теперь даггер сможет собрать коллекцию Set<EventHandlerElementsIntoSet>, состоящую из двух этих объектов.(Analytics,Logger)
А получить ее мы можем, прописав в компоненте соответствующий метод:
  fun getEventHandlersElementIntoSet(): Set<EventHandlerElementsIntoSet>
 */

