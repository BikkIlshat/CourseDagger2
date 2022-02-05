package com.github.bikkilshat.coursedagger_2.di

import com.github.bikkilshat.coursedagger_2.presenter.MainActivityPresenter
import dagger.Component

/***
Совокупность всех объектов, которые умеет создавать компонент - это граф объектов компонента или граф зависимостей компонента.
 */

@Component(modules = [StorageModule::class, NetworkModule::class, MainModule::class])
interface AppComponent {
  //Теперь даггер знает, как создавать объект MainActivityPresenter. И мы можем попросить этот объект у компонента:
  //Создаем get метод, который будет возвращать презентер.
  fun getMainActivityPresenter(): MainActivityPresenter

  /*
Граф зависимостей компонента теперь включает три объекта:
MainActivityPresenter, DatabaseHelper, NetworkUtils.
Причем нам нужен только один из них - презентер.
Два других мы напрямую у компонента не запрашиваем, но он сам создает их, чтобы создать презентер.
 */
}

