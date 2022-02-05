package com.github.bikkilshat.coursedagger_2.network

/***
 * Объект, который мы будем запрашивать от дагера:
 * Давайте чуть усложним пример.
 * Сделаем так, чтобы объект NetworkUtils сам в свою очередь был составным и требовал другой объект при своем создании.
 */
class NetworkUtils(private val connectionManager: ConnectionManager) {

}


/*
Чтобы это заработало нам нужно будет сделать следующее:
1) В модуле NetworkModule  создать Provides метод для создания объекта ConnectionManager

2) Добавить  ConnectionManager как аргумент в Provides метод создания
  fun provideNetworkUtils (connectionManager: ConnectionManager) NetworkUtils:
      return return ConnectionManager()
 */