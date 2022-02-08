package com.github.bikkilshat.coursedagger_2.di

import android.app.Activity
import com.github.bikkilshat.coursedagger_2.presenter.MainActivityPresenter
import com.github.bikkilshat.coursedagger_2.storage.DatabaseHelper
import dagger.BindsInstance
import dagger.Subcomponent

/*
Интерфейс для сабкомпонента создается точно так же, как и для компонента, только аннотация используется другая - @Subcomponent:
 */
@Subcomponent(modules = [MainModule::class]) //В списке модулей мы указываем MainModule, чтобы сабкомпонент знал, как этот презентер создается.
interface MainComponent {
  //Кастомный билдер для сабкомпонента создается таким же способом, как и билдер для обычного компонента:

  /*
Factory
Еще один способ передать объекты сабкомпоненту - это Factory. Ее мы уже проходили в уроке про билдеры. Для сабкомпонента все аналогично.
   */
  @Subcomponent.Factory
  interface Factory {
    fun create(@BindsInstance activity: Activity): MainComponent //У сабкомпонента будет Activity и он сможет его использовать для создания презентера

  }

  //В интерфейсе мы описываем get метод для получения презентера.
  fun getMainActivityPresenter(): MainActivityPresenter

  fun getDatabaseHelper(): DatabaseHelper

}
/*
Мы настроили кастомный билдер у сабкомпонента. Как нам теперь получить этот билдер,
чтобы создать сабкомпонент? Мы можем попросить его у компонента родителя:

@Component(modules = [StorageModule::class, NetworkModule::class........])
interface AppComponent {
   fun getMainComponentBuilder(): MainComponent.Builder

}
 */