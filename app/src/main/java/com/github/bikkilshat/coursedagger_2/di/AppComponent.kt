package com.github.bikkilshat.coursedagger_2.di

import com.github.bikkilshat.coursedagger_2.intoMap.EventHandlerIntoMap
import com.github.bikkilshat.coursedagger_2.intoMap.EventHandlerType
import com.github.bikkilshat.coursedagger_2.intoMap.EventModuleIntoMap
import com.github.bikkilshat.coursedagger_2.intoSet.EvenModule
import com.github.bikkilshat.coursedagger_2.intoSet.EventHandler
import com.github.bikkilshat.coursedagger_2.network.ServerApi
import com.github.bikkilshat.coursedagger_2.presenter.MainActivityPresenter
import com.github.bikkilshat.coursedagger_2.storage.DatabaseHelper
import dagger.Component

/***
Совокупность всех объектов, которые умеет создавать компонент - это граф объектов компонента или граф зависимостей компонента.
 */

@Component(modules = [StorageModule::class, NetworkModule::class, MainModule::class, EvenModule::class, EventModuleIntoMap::class])
interface AppComponent {

  /* аннотации @Qualifier
  Они так же, как и Named, помогут даггеру различать два способа создания объекта ServerApi.
   И мы, соответственно, используем одну из них, чтобы сказать компоненту, какой именно ServerApi нам нужен:
   */

  @NetworkModule.Prod("2") //  сказали компоненту вернуть ServerApi с Qualifier Prod
  fun getServerApiProd(): ServerApi

  /*IntoSet
  Теперь даггер сможет собрать коллекцию Set<EventHandler>, состоящую из двух  объектов:
  fun provideAnalytics(): EventHandler
  fun provideLogger(): EventHandler
   */

  fun getEventHandlers(): Set<EventHandler>

  fun DatabaseHelper.getEventHandlers(): Set<EventHandler>

  fun getMainActivityPresenter(): MainActivityPresenter

  /*IntoMap
  Теперь даггер сможет собрать коллекцию Set<EventHandler>, состоящую из двух  объектов:
  fun provideAnalytics(): EventHandlerIntoMap
  fun provideLogger(): EventHandlerIntoMap
   */

//  fun getEventHandlersIntoMap(): Map<String, EventHandlerIntoMap> пример с ключом String


  //пример когда создали свою аннотацию EventHandlerKey с помощью MapKey
  fun getEventHandlersIntoMap(): Map<EventHandlerType, EventHandlerIntoMap>

}

