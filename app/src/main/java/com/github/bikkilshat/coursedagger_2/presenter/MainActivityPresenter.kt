package com.github.bikkilshat.coursedagger_2.presenter

import com.github.bikkilshat.coursedagger_2.storage.DatabaseHelper
import com.github.bikkilshat.coursedagger_2.network.NetworkUtils
import javax.inject.Inject

//добавить аннотацию @Inject constructor к конструктору объекта:
class MainActivityPresenter  @Inject constructor(
  private val databaseHelper: DatabaseHelper,
  private val networkUtils: NetworkUtils
) {

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