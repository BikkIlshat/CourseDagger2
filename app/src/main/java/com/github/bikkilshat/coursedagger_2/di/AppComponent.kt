package com.github.bikkilshat.coursedagger_2.di

import android.content.Context
import com.github.bikkilshat.coursedagger_2.MainActivity
import com.github.bikkilshat.coursedagger_2.elementsIntoSet.EvenModuleElementsIntoSet
import com.github.bikkilshat.coursedagger_2.elementsIntoSet.EventHandlerElementsIntoSet
import com.github.bikkilshat.coursedagger_2.intoMap.EventHandlerIntoMap
import com.github.bikkilshat.coursedagger_2.intoMap.EventHandlerType
import com.github.bikkilshat.coursedagger_2.intoMap.EventModuleIntoMap
import com.github.bikkilshat.coursedagger_2.intoSet.EvenModule
import com.github.bikkilshat.coursedagger_2.intoSet.EventHandler
import com.github.bikkilshat.coursedagger_2.network.ServerApi
import com.github.bikkilshat.coursedagger_2.presenter.MainActivityPresenter
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent

/***
Совокупность всех объектов, которые умеет создавать компонент - это граф объектов компонента или граф зависимостей компонента.
 */

@Component(modules = [
  StorageModule::class,
  NetworkModule::class,
  EvenModule::class,
  EventModuleIntoMap::class,
  EvenModuleElementsIntoSet::class,
  AppModule::class
])
interface AppComponent {

  @NetworkModule.Prod("2") //  сказали компоненту вернуть ServerApi с Qualifier Prod
  fun getServerApiProd(): ServerApi

  fun getEventHandlers(): Set<EventHandler>

  //пример когда создали свою аннотацию EventHandlerKey с помощью MapKey
  fun getEventHandlersIntoMap(): Map<EventHandlerType, EventHandlerIntoMap>

  // ElementsIntoSet
  fun getEventHandlersElementIntoSet(): Set<EventHandlerElementsIntoSet>

  // этот метод из @Subcomponent
  //Т.е. мы у компонента просим не сам сабкомпонент, а его кастомный билдер, который мы описывали.
  fun getMainComponentBuilder(): MainComponent.Builder


  @Component.Factory
  interface AppCompFactory {
    fun create(
      @BindsInstance
      context: Context,
      networkModule: NetworkModule,
    ): AppComponent
  }

}

