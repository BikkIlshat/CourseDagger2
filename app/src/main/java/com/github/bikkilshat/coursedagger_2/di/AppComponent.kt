package com.github.bikkilshat.coursedagger_2.di

import com.github.bikkilshat.coursedagger_2.DatabaseHelper
import com.github.bikkilshat.coursedagger_2.NetworkUtils
import dagger.Component

/***
 * После создания класса App
 * Нам остается рассказать компоненту, какие именно объекты мы хотим от него получать.
 * Для этого мы будем наполнять его интерфейс методами.
 * И вот тут у нас есть два вида методов:
 */

//Нам от компонента нужны объекты DatabaseHelper и NetworkUtils. Для этого нам надо просто добавить
// в интерфейс компонента методы, которые будут возвращать эти объекты:
@Component(modules = [StorageModule::class, NetworkModule::class])
interface AppComponent {
  /*
  Создаем два метода. Они могут быть с любым именем, главное - это их возвращаемые типы (NetworkUtils и DatabaseHelper).
  Они дают понять компоненту, какие именно объекты мы хотим от него получать.
  При компиляции, даггер проверит, в каком модуле какой объект можно достать,
  и нагенерит в реализации двух этих методов соответствующий код создания этих объектов.
   */
  fun getNetworkUtils(): NetworkUtils // В  NetworkModule он найдет код для создания NetworkUtils
  fun getDatabaseHelper(): DatabaseHelper  //  в  StorageModule он найдет код для создания DatabaseHelper

  /*
  Список modules (modules = [StorageModule::class, NetworkModule::class]) - это модули.
  Здесь нам надо указать модули, в которых компонент сможет найти
  код создания объектов. В StorageModule он найдет код для создания DatabaseHelper,
  а в NetworkModule - для NetworkUtils.
   */
}


