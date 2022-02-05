package com.github.bikkilshat.coursedagger_2.network

/*
                                                  Named
Иногда бывает необходимость создавать несколько объектов одного класса, но с разными входными данными.
Рассмотрим пример. У нас есть некий класс для работы с сервером:
 */
class ServerApi(private val host: String) {
}
/*
На вход он требует указать ему имя хоста. У нас есть два варианта хоста:
prod.server.com и dev.server.com.
Создаем два разных ServerApi в модуле даггера:
 */