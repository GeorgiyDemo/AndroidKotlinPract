package com.demka.androidkotlin5

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import com.beust.klaxon.Klaxon
import kotlinx.android.synthetic.main.activity_main.*
import java.net.HttpURLConnection
import java.net.URL


abstract class Lesson
{
    abstract var auditorium: String
    abstract var auditoriumAmount:Int
    abstract  var auditoriumOid:Int
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    @RequiresApi(Build.VERSION_CODES.N)
    fun mainButtonClick(view: View)
    {
        Log.d("LOGS","Нажата кнопка")
        Thread {
            var bufresult  = sendGet()


            /*
            val result = Klaxon()
                    .parse<Lesson>(bufresult)
            */

            runOnUiThread{
                mainText.text = bufresult
            }



        }.start()



    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun sendGet() : String
    {
            var outString:String = ""
            val url = URL("https://ruz.fa.ru/api/schedule/group/9569?start=2020.05.18&finish=2020.05.18&lng=1")

            with(url.openConnection() as HttpURLConnection) {
                requestMethod = "GET"  // optional default is GET

                println("\nSent 'GET' request to URL : $url; Response Code : $responseCode")

                inputStream.bufferedReader().use {
                    it.lines().forEach { line ->
                        outString += line;
                    }
                }

            }
        return outString
    }
}
