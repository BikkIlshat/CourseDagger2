package com.github.bikkilshat.coursedagger_2.di

import com.github.bikkilshat.coursedagger_2.network.NetworkUtils
import dagger.Component
import dagger.Lazy

/***
Совокупность всех объектов, которые умеет создавать компонент - это граф объектов компонента или граф зависимостей компонента.
 */

@Component(modules = [StorageModule::class, NetworkModule::class, MainModule::class])
interface AppComponent {

  fun getNetworkUtils(): Lazy<NetworkUtils> // Оборачиваем NetworkUtils в Lazy.

}

