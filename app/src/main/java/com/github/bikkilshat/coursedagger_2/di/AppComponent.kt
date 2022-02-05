package com.github.bikkilshat.coursedagger_2.di

import com.github.bikkilshat.coursedagger_2.network.ServerApi
import dagger.Component

/***
Совокупность всех объектов, которые умеет создавать компонент - это граф объектов компонента или граф зависимостей компонента.
 */

@Component(modules = [StorageModule::class, NetworkModule::class, MainModule::class])
interface AppComponent {

  /* аннотации @Qualifier
  Они так же, как и Named, помогут даггеру различать два способа создания объекта ServerApi.
   И мы, соответственно, используем одну из них, чтобы сказать компоненту, какой именно ServerApi нам нужен:
   */

  @NetworkModule.Prod //  сказали компоненту вернуть ServerApi с Qualifier Prod
  fun getServerApiProd(): ServerApi

}

