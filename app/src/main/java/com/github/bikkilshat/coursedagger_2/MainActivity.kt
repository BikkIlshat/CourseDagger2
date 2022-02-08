package com.github.bikkilshat.coursedagger_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.bikkilshat.coursedagger_2.di.MainComponent
import com.github.bikkilshat.coursedagger_2.presenter.MainActivityPresenter
import javax.inject.Inject


class MainActivity : AppCompatActivity() {


  @Inject
  lateinit var mainComponentFactory: MainComponent.Factory

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    //Чтобы добраться до компонента из MainActivity, мы можем сделать так:
    (application as App).appComponent.injectMainActivity(this)

    val mainComponent = mainComponentFactory.create(this)
  }
}