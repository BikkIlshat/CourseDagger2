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
import dagger.BindsInstance
import dagger.Component

/***
Совокупность всех объектов, которые умеет создавать компонент - это граф объектов компонента или граф зависимостей компонента.
 */

@Component(modules = [
  StorageModule::class,
  NetworkModule::class,
  MainModule::class,
  EvenModule::class,
  EventModuleIntoMap::class,
  EvenModuleElementsIntoSet::class,
  AppModule::class //Но у компонента возникает проблема. Его билдер теперь не может создать объект модуля AppModule, потому что конструктору AppModule требуется Context.
])
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

  // fun getMainActivityPresenter(): MainActivityPresenter\

  fun injectMainActivity(mainActivity: MainActivity)

  /*IntoMap
  Теперь даггер сможет собрать коллекцию Set<EventHandler>, состоящую из двух  объектов:
  fun provideAnalytics(): EventHandlerIntoMap
  fun provideLogger(): EventHandlerIntoMap
   */

//  fun getEventHandlersIntoMap(): Map<String, EventHandlerIntoMap> пример с ключом String


  //пример когда создали свою аннотацию EventHandlerKey с помощью MapKey
  fun getEventHandlersIntoMap(): Map<EventHandlerType, EventHandlerIntoMap>


  // ElementsIntoSet
  ////В итоге, когда даггер будет собирать нам коллекцию Set<EventHandlerElementsIntoSet>, он добавит туда все элементы из databaseHelper.getEventHandlers().
  fun getEventHandlersElementIntoSet(): Set<EventHandlerElementsIntoSet>


  /*
  Урок 6. Builder, Factory
  Даггер дает нам возможность кастомизировать стандартный билдер.
  Прямо в интерфейсе компонента (AppComponent) мы описываем интерфейс билдера - AppCompBuilder с аннотацией @Component.Builder.
//   */
//  @Component.Builder
//  interface AppCompBuilder {
//    // В интерфейсе билдера мы, как минимум, должны описать build метод, который будет создавать компонент.
//    fun buildAppComp(): AppComponent // Имя метода значения не имеет (например, buildAppComp), но он должен быть без аргументов и возвращать AppComponent.
//    // Используем свой билдер, чтобы создать компонент переходим в class App
//
//    /*
//    Чтобы кастомный билдер мог принимать от нас модули, созданные вручную,
//    надо добавить соответствующие методы. Рассмотрим на примере модуля AppModule,
//     который мы рассматривали на прошлом уроке:
//     */
//    fun appModule(appModule: AppModule): AppCompBuilder
//    //Метод должен принимать на вход объект AppModule, а на выходе возвращать билдер AppCompBuilder.
//    // Имя метода может быть любым, я использовал appModule.
//
//    //Даггер создаст в билдере этот метод, и мы сможем его использовать для передачи модуля
//    // в компонент при создании компонента:
////    appComponent = DaggerAppComponent
////    .builder()
////    .appModule(AppModule(this))
////    .buildAppComp()
//
//    /*
//    BindsInstance
//Ранее мы рассмотрели пример, когда с помощью конструктора AppModule мы передавали компоненту объект Context.
//Кастомный билдер дает нам возможность передачи объекта без участия модуля.
//Для этого необходимо описать в кастомном билдере метод с аннотацией @BindsInstance:
//
////     */
////    @BindsInstance
////    //На вход он должен принимать объект, который мы хотим передать компоненту.
////    fun context(context: Context): AppCompBuilder // А на выходе должен возвращать билдер.
////// Теперь Context можно убрать из конструктора AppModule. У компонента будет доступ к этому объекту напрямую, и он сможет передать его в Provides методы для получения SharedPreferences и Resources:
//
//    /*
//    Передаем Context напрямую в компонент с помощью кастомного билдера:
//    appComponent = DaggerAppComponent
//   .builder()
//   .context(this)
//   .buildAppComp()
//     */
//    //В документации указано, что этот способ является более предпочтительным,
//    // чем передача через конструктор модуля.!!!!
//  }

  /*
  С версии 2.22 в даггере появился еще один способ создать компонент.
  Вместо билдера с несколькими методами, мы можем использовать один метод с несколькими аргументами. Для этого используется Factory.
   */
  @Component.Factory
  interface AppCompFactory {
    fun create(
      @BindsInstance
      context: Context,
      networkModule: NetworkModule,
    ): AppComponent
  }
/*
Внутри компонента нам надо создать интерфейс с аннотацией @Component.Factory.
Имя интерфейса может быть любым. А метод будет только один.
 Он должен принимать на вход все @BindsInstance объекты и модули, которые нужны компоненту.
  А на выходе он должен возвращать компонент. Т.е. получается билдер, упакованный в один метод.
 */

}

