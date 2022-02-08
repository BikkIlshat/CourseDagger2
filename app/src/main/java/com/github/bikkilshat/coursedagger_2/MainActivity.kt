package com.github.bikkilshat.coursedagger_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.bikkilshat.coursedagger_2.presenter.MainActivityPresenter
import javax.inject.Inject


class MainActivity : AppCompatActivity() {


  @Inject
  lateinit var mainActivityPresenter: MainActivityPresenter

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    //Чтобы добраться до компонента из MainActivity, мы можем сделать так:
    val mainComponent = (application as App).appComponent.getMainComponentBuilder()
      .activity(this)
      .build()
  }
}