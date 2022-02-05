package com.github.bikkilshat.coursedagger_2.di

import com.github.bikkilshat.coursedagger_2.DatabaseHelper
import com.github.bikkilshat.coursedagger_2.NetworkUtils
import com.github.bikkilshat.coursedagger_2.presenter.MainActivityPresenter
import dagger.Module
import dagger.Provides

/*
Создаем модуль, а в нем Provides метод, который будет создавать объект MainActivityPresenter:
 */
@Module
class MainModule {
  /*
  у MainActivityPresenter нет пустого конструктора.  Ему нужны DatabaseHelper и NetworkUtils.
  Где их взять? Просто добавить как аргументы метода и использовать их в конструкторе:
   */


  @Provides
  fun provideMainActivityPresenter(databaseHelper: DatabaseHelper, networkUtils: NetworkUtils): MainActivityPresenter {
    return MainActivityPresenter(databaseHelper, networkUtils)
  }

  /*
  Когда мы попросим даггер создать презентер, он обратится к методу provideMainActivityPresenter
  и увидит, что ему на вход требуются объекты DatabaseHelper и NetworkUtils.
   И т.к. даггер уже умеет создавать эти объекты,
   то он просто создаст их и передаст в этот метод и получит созданный презентер.

Т.е. даггер создает объекты не только для того, чтобы вернуть их нам или заинджектить куда-либо,
но и для своих внутренних целей, если это потребуется.
   */
}