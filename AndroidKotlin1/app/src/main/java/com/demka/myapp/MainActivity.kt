/*
Пример работы с разными потоками и элементами
 */

package com.demka.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private var check_number1: Byte = 32;
    private var check_number2: Byte = 1;
    private var text: String = "Пример текста РАЗ РАЗ";
    private var MainText: TextView? = null;
    private var counter:Int = 0;
    private var startBoolean:Boolean = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var result = check_number1 + check_number2;
        MainText = findViewById(R.id.MainTextLabel);
        MainText?.setText(counter.toString());

        Thread{

            startBoolean = true;
            while (startBoolean)
            {
                Thread.sleep(10);
                counter++;
                runOnUiThread {
                    MainText?.setText(counter.toString());
                }
            }
        }.start()

    }

    override fun onDestroy() {
        super.onDestroy()
        startBoolean = false;
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()

    }

    override fun onStop() {
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
    }



}