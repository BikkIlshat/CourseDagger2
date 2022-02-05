package com.github.bikkilshat.coursedagger_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.bikkilshat.coursedagger_2.network.ServerApi
import javax.inject.Inject
import javax.inject.Named


class MainActivity : AppCompatActivity() {


//  //На стороне получателя уже никаких аннотаций указывать не надо:
//  lateinit var serverApi: ServerApi

  //А вот на стороне получателя уже надо будет указать Named, чтобы даггер знал, какой именно ServerApi инджектить:
  @Inject
  @Named("prod")
  lateinit var serverApi: ServerApi

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    //Чтобы добраться до компонента из MainActivity, мы можем сделать так:
//    serverApi = (application as App).appComponent.getServerApiProd()


    (application as App).appComponent.injectMainActivity(this)

  }
}