package com.demka.androidkotlin2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var number1 = 6
    private var number2 = 164
    private var sstring  = "Пример отображения суммы: |$number1\$| + |$number2\$| = ${getNumber()}\$";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Присваиваем весь текст:
        MainTextLabel.text = sstring

        //Коллекция с индексами символа
        var localeList: MutableList<Int> = mutableListOf()


        for (i in 0..sstring.length-1) {
            if (sstring[i].toString() == "|") {
                localeList.add(i)
            }
        }

        //Присваиваем первое значение
        val firstValue = sstring.slice(localeList[0]..localeList[1]);
        FirstTextLabel.text = "Значение №1: $firstValue";

        //Присваиваем второе значение
        val secondValue = sstring.slice(localeList[2]..localeList[3]);
        SecondTextLabel.text = "Значение №2: $secondValue"
    }

    private fun getNumber() : Int {
        return number1 + number2;
    }

}