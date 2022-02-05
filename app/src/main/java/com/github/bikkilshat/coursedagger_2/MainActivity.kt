package com.github.bikkilshat.coursedagger_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.bikkilshat.coursedagger_2.network.NetworkUtils
import dagger.Lazy


class MainActivity : AppCompatActivity() {

  /*
  Что если этот объект нужен нам не всегда, а только в некоторых случаях.
  Например, когда пользователь жмет на экране определенную кнопку.
  Т.е. может быть так, что пользователь уйдет с экрана так и не нажав эту кнопку.
  Тогда получится что мы зря создавали объект NetworkUtils.
  В таких случаях обычно используется ленивое создание объекта.
  Даггер умеет это делать из коробки с помощью Lazy обертки:
   */

  private lateinit var networkUtilsLazy: Lazy<NetworkUtils> // тоже самое далаем на стороне component


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    //Чтобы добраться до компонента из MainActivity, мы можем сделать так:
    networkUtilsLazy = (application as App).appComponent.getNetworkUtils()
    //Все последующие вызовы get уже не будут создавать новые NetworkUtils объекты,
  // а будут возвращать тот, который был создан при первом вызове get.
  }

  /*
  Provider
Полностью аналогичен Lazy, но при каждом вызове get он будет создавать новый объект. Т.е. это фактически фабрика объекта.
   */

}