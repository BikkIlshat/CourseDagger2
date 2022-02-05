package com.github.bikkilshat.coursedagger_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.bikkilshat.coursedagger_2.di.App

class MainActivity : AppCompatActivity() {
    lateinit var databaseHelper: DatabaseHelper
    lateinit var networkUtils: NetworkUtils

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Чтобы добраться до компонента из MainActivity, мы можем сделать так:
        val appComponent = (application as App).appComponent

        databaseHelper = appComponent.getDatabaseHelper()
        networkUtils = appComponent.getNetworkUtils()
    }
}