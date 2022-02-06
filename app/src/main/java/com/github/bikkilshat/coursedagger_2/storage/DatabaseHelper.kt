package com.github.bikkilshat.coursedagger_2.storage

import com.github.bikkilshat.coursedagger_2.elementsIntoSet.EventHandlerElementsIntoSet
import javax.inject.Inject

/***
 * Объект, который мы будем запрашивать от дагера:
 *
 * Давайте чуть усложним пример.
 * Сделаем так, чтобы объект DatabaseHelper сам в свою очередь был составным и требовал другой объект при своем создании.
 */
class DatabaseHelper @Inject constructor(private val repository: Repository) {

  fun getEventHandlers(): Set<EventHandlerElementsIntoSet> {
    TODO("Not yet implemented")
  }

}

