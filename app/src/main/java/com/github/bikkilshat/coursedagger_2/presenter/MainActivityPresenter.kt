package com.github.bikkilshat.coursedagger_2.presenter

import com.github.bikkilshat.coursedagger_2.DatabaseHelper
import com.github.bikkilshat.coursedagger_2.NetworkUtils

/*
В примерах прошлого урока граф  (@Component) состоял всего из двух объектов: DatabaseHelper и NetworkUtils.
Эти объекты имели пустые конструкторы и легко создавались.
Но чаще мы имеем дело с более сложными объектами, у которых в конструктор должны передаваться другие объекты.
Т.е. компоненту для создания одного объекта может потребоваться создать другой объект. Давайте посмотрим, как это сделать в даггере.
 */
class MainActivityPresenter(
  private val databaseHelper: DatabaseHelper,
  private val networkUtils: NetworkUtils
) {

  /*
  Это презентер для MainActivity. Для создания ему требуются DatabaseHelper и NetworkUtils.
  Давайте научим даггер создавать такой презентер. Создадим для него class MainModule с аннотацией @Module
  а в нем Provides метод, который будет создавать объект MainActivityPresenter:
   */
}