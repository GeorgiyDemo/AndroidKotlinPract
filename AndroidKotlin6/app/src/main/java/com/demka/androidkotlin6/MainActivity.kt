package com.demka.androidkotlin6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var nameLisl0  = listOf("Пример1", "пример2")

        var nameList1 = ArrayList<String>()
        nameList1.add("Кот")
        nameList1.add("Кот1")

        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, nameList1)
        listView.adapter = adapter

        listView.setOnItemClickListener{parent, view, position, id ->
            val textValue = nameList1[position]
            Toast.makeText(this, "Нажали на $textValue с позицией  $position",Toast.LENGTH_SHORT).show()
        }
    }
}