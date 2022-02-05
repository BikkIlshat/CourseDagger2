package com.github.bikkilshat.coursedagger_2.storage

/***
 * Объект, который мы будем запрашивать от дагера:
 *
 * Давайте чуть усложним пример.
 * Сделаем так, чтобы объект DatabaseHelper сам в свою очередь был составным и требовал другой объект при своем создании.
 */
class DatabaseHelper(private val repository: Repository) {
}

/*
Чтобы это заработало нам нужно будет сделать следующее:
1) В модуле StorageModule  создать Provides метод для создания объекта Repository

2) Добавить  Repository как аргумент в Provides метод создания
 fun provideRepository(): Repository {
    return Repository()
  }
 */