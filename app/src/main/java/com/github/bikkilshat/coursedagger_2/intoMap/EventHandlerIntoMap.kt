package com.github.bikkilshat.coursedagger_2.intoMap

import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import dagger.multibindings.StringKey

/**
 * IntoMap
Эта аннотация аналогична IntoSet, но собирает объекты не в Set, а в Map.
А от нас требуется указать ключ, с которым объект будет помещен в Map.
 */

class Event {}

/*
Мы хотим пропускать его через несколько обработчиков EventHandler:
 */
interface EventHandlerIntoMap {
  fun handle (event: Event)

}

/*
Такими обработчиками могут быть, например, аналитика и логи:
 */
class Analytics: EventHandlerIntoMap {
  override fun handle(event: Event) {
    // ...
  }

}
class Logger: EventHandlerIntoMap {
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
class EventModuleIntoMap {

  @IntoMap
 // @StringKey("analytics")
  @EventHandlerKey(EventHandlerType.ANALYTICS)
  @Provides
  fun provideAnalytics(): EventHandlerIntoMap {
    return Analytics()
  }

  @IntoMap
 // @StringKey("logger")
  @EventHandlerKey(EventHandlerType.LOGGER)
  @Provides
  fun provideLogger(): EventHandlerIntoMap {
    return Logger()
  }

  //И в компоненте просим даггер дать нам Map с нашим созданным типом ключа - Map<EventHandlerType, EventHandler>:

}
/*
Используя ключ типа String, мы тем самым определили тип ключа в Map.
Даггер соберет объекты в Map<String, EventHandler>
А получить ее мы можем, прописав в компоненте соответствующий метод:
  fun getEventHandlersIntoMap(): Map<String, EventHandlerIntoMap>
 */


/*
Кроме String, даггер также предоставляет аналогичные аннотации для Map-ключей с типами Long, Int и Class.
Если этого недостаточно, можно создать свою аннотацию, которая задаст нужный нам тип ключа.
Допустим, вместо текста в качестве ключа мы хотим использовать enum. Создаем enum класс:
 */

enum class EventHandlerType {
  ANALYTICS, LOGGER
}
//Создаем свою аннотацию EventHandlerKey с помощью MapKey:

@MapKey
@Retention(AnnotationRetention.RUNTIME)
annotation class EventHandlerKey(val value: EventHandlerType)

//Указываем, что требуется значение с типом EventHandlerType. Это и будет ключом в коллекции Map.
//Используем созданную аннотацию с Provides методами в созданном модуле EventModuleIntoMap