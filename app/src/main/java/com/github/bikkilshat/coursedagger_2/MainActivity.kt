package com.github.bikkilshat.coursedagger_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.bikkilshat.coursedagger_2.intoSet.EventHandler
import com.github.bikkilshat.coursedagger_2.network.NetworkUtils
import com.github.bikkilshat.coursedagger_2.network.ServerApi
import com.github.bikkilshat.coursedagger_2.presenter.MainActivityPresenter
import com.github.bikkilshat.coursedagger_2.storage.DatabaseHelper
import javax.inject.Inject


class MainActivity : AppCompatActivity() {


  lateinit var mainActivityPresenter: MainActivityPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    //Чтобы добраться до компонента из MainActivity, мы можем сделать так:
    mainActivityPresenter = (application as App).appComponent.getMainActivityPresenter()

  }
}