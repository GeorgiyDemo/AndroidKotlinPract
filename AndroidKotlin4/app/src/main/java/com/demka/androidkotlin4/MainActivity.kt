package com.demka.androidkotlin4

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : Activity() {

    //Главная изображенька светофора
    private var mainImg: ImageView? = null

    //Переменная-флаг, что светофор работает
    private var booleanFlag = false

    //Переменная-счетчик
    private  var mainCounter: Int = 0

    //Массив для хранения ресурсов
    private var ImageArray:IntArray = intArrayOf(R.drawable.semafor_red, R.drawable.semafor_yellow, R.drawable.semafor_green)

    //Переменная-таймер
    var timer: Timer? = null

    /*
    Главное активити
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainImg = findViewById(R.id.MainImg)

    }

    /*
    Событийная функция нажатия на button старта/стопа светофора
     */
    fun onClickStartStop(view: View){
        view as ImageButton

        if (!booleanFlag)
        {
            timer = Timer()
            startStop()
            runOnUiThread {
                view.setImageResource(R.drawable.button_stop)
            }
            booleanFlag = true
        }

        else
        {
            mainCounter = 0
            timer?.cancel()
            runOnUiThread {
                MainImg.setImageResource(R.drawable.semafor_grey)
                view.setImageResource(R.drawable.button_start)
            }
            booleanFlag = false
        }
    }

    /*
    Функция для таймера
    */

    fun startStop(){
        timer?.schedule(object:  TimerTask(){
            override fun run() {

                runOnUiThread {
                    if (mainCounter == 3) {
                        mainCounter = 0
                    }
                    mainImg?.setImageResource(ImageArray[mainCounter])
                    mainCounter++
                }
            }
        }, 0,500)

    }
}