package com.github.bikkilshat.coursedagger_2.di

import com.github.bikkilshat.coursedagger_2.MainActivity
import com.github.bikkilshat.coursedagger_2.network.ServerApi
import dagger.Component
import javax.inject.Named

/***
Совокупность всех объектов, которые умеет создавать компонент - это граф объектов компонента или граф зависимостей компонента.
 */

@Component(modules = [StorageModule::class, NetworkModule::class, MainModule::class])
interface AppComponent {

  @Named("prod")
  fun getServerApiProd(): ServerApi
  /*
    fun getServerApiProd(): ServerApi
  Уже тут возникает вопрос: а какой именно объект ServerApi из двух возможных создаст нам даггер.
  Если мы попытаемся запустить проект, то получим ошибку:
  ServerApi is bound multiple times
  Даггер видит, что есть два способа создать объект ServerApi. И он не знает, какой именно надо использовать. Решается это аннотацией Named.
  Добавим Named к Provides методам:

  //На стороне получателя уже никаких аннотаций указывать не надо:
   */

//Если же мы в компоненте используем не get, а inject метод, то в компоненте аннотации не нужны:
//fun injectMainActivity(mainActivity: MainActivity)


}

