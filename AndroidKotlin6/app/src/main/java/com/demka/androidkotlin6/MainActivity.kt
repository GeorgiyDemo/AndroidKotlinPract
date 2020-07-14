package com.demka.androidkotlin6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nameLisl0  = listOf("Пример1", "пример2")

        var nameList1 = ArrayList<String>()
    }
}