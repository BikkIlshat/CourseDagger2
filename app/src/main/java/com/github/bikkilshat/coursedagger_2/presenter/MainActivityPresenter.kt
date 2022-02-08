package com.github.bikkilshat.coursedagger_2.presenter

import android.app.Activity
import com.github.bikkilshat.coursedagger_2.MainActivity
import com.github.bikkilshat.coursedagger_2.network.NetworkUtils
import com.github.bikkilshat.coursedagger_2.storage.DatabaseHelper
import javax.inject.Inject

//добавить аннотацию @Inject constructor к конструктору объекта:
class MainActivityPresenter @Inject constructor(
  private val databaseHelper: DatabaseHelper,
  private val networkUtils: NetworkUtils,
  private val activity: Activity
) {

}

