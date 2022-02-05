package com.github.bikkilshat.coursedagger_2.intoSet

import com.github.bikkilshat.coursedagger_2.storage.DatabaseHelper
import dagger.Module
import dagger.Provides
import dagger.multibindings.ElementsIntoSet
import dagger.multibindings.IntoSet

/**
 * IntoSet
Если нам необходимо от компонента получить несколько однотипных объектов, мы можем запросить их сразу как Set.
Рассмотрим на примере. Пусть у нас есть какое-то глобальное событие Event
 */

class Event {}

/*
Мы хотим пропускать его через несколько обработчиков EventHandler:
 */
interface EventHandler {
  fun handle (event: Event)

}

/*
Такими обработчиками могут быть, например, аналитика и логи:
 */
class Analytics: EventHandler {
  override fun handle(event: Event) {
    // ...
  }

}
class Logger: EventHandler {
  override fun handle(event: Event) {
    // ...
  }

}
/*
Было бы удобно сразу получить от даггера готовый набор обработчиков, а не по одному.
 Даггер может собрать их для нас в коллекцию Set.
Для этого используем аннотацию IntoSet c Provides методами обработчиков:
 */

@Module
class EvenModule {

  @IntoSet
  @Provides
  fun provideAnalytics(): EventHandler {
    return Analytics()
  }

  @IntoSet
  @Provides
  fun provideLogger(): EventHandler {
    return Logger()
  }

}
/*
Обратите внимание, что тип возвращаемого значения у этих методов - EventHandler.
Теперь даггер сможет собрать коллекцию Set<EventHandler>, состоящую из двух этих объектов.
А получить ее мы можем, прописав в компоненте соответствующий метод:
 */

