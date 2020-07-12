package com.demka.androidkotlin3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mainString: String = "<Пример> строки для <парсинга> через <циклы>"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Массив для хранения слов, которые спарсили
        var mainStringList: MutableList<String> = mutableListOf()
        //Счетчик кол-ва слов
        var localeCounter = 0;


        for(i in 0..mainString.length-1)
        {
            if (mainString[i] == '<') {

                //Строка, которую извлекли
                var bufString = mainString.substring(i+1).substringBefore(">")
                //Добавляем в коллекцию
                mainStringList.add(bufString)
                //Логирование, запомнить синтаксис
                Log.d("Mylog","Извлекли строку $bufString")
                localeCounter++;
            }
        }

        //Формируем выходную строку
        var finalOutString = "Пример парсинга строки на Kotlin\nИсходная строка: $mainString\n\nРезультат:"

        //Добавляем элементы коллекции в строку
        for (substring in mainStringList){
            finalOutString += "\n$substring"
        }
        MainText.text = finalOutString
        CountWordsText.text = "Общее кол-во слов после парсинга: $localeCounter"
    }





}