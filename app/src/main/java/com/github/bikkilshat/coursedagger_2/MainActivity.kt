package com.github.bikkilshat.coursedagger_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.bikkilshat.coursedagger_2.presenter.MainActivityPresenter

class MainActivity : AppCompatActivity() {

  lateinit var mainActivityPresenter: MainActivityPresenter


  /*
Аннотациями @Inject мы помечаем поля, которые компонент должен заполнить (инджектить).
При вызове метода injectMainActivity компонент создаст объекты DatabaseHelper и NetworkUtils
и поместит их в соответствующие поля MainActivity.
 */

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    //Чтобы добраться до компонента из MainActivity, мы можем сделать так:
    mainActivityPresenter = (application as App).appComponent.getMainActivityPresenter()
  }


}