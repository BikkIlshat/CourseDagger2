package com.github.bikkilshat.coursedagger_2.presenter

import com.github.bikkilshat.coursedagger_2.network.NetworkUtils
import com.github.bikkilshat.coursedagger_2.storage.DatabaseHelper
import javax.inject.Inject

//добавить аннотацию @Inject constructor к конструктору объекта:
class MainActivityPresenter  @Inject constructor(
  private val databaseHelper: DatabaseHelper,
 // private val networkUtils: NetworkUtils, //закоментил для примера инжекта в метод
//@Dev private val serverApi: ServerApi //  Если в конструкторе необходимо получить объект с аннотацией Named или Qualifier, то просто указывайте ее перед объектом:

) {
  /*
  Методы
Использование аннотации Inject с методами не так распространено, как с конструктором, но иногда бывает полезным.
Мы можем пометить метод объекта аннотацией Inject, и этот метод будет вызван даггером при создании
объекта или инджекте в него. Давайте рассмотрим на примерах.
   */

  @Inject
  fun postInit(networkUtils: NetworkUtils) {
    // ...
  }
  /*
  Важно. Если даггер создает объект с помощью Provides метода из модуля,
  а не создает сам Inject конструктором, то Inject методы вызваны не будут.
   */
}

/*
И все. Даггер теперь сам может создать этот объект, используя его конструктор.
 А Provides метод в  MainModule модуле больше не нужен, его можно удалить.
 Т.е. Inject конструктор - это просто альтернатива Provides методу. Все остальное работает точно также.
 Объект созданный этим способом:
- может быть получен от компонента get-методом
- может быть заинджектен компонентом
- может быть использован как аргумент в Provides методе создания другого объекта
 */