package com.demka.androidkotlin5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun mainButtonClick(view: View)
    {
        if (mainTextInput.text.toString() != ""){
            alertTextLabel.visibility = View.INVISIBLE
            val userDataText = mainTextInput.text
            val intent = Intent(this, MainActivity2::class.java).apply{
                putExtra("UserData", userDataText)
            }
            startActivity(intent)
        }
        else
        {
            alertTextLabel.visibility = View.VISIBLE
        }
    }

    override fun onResume() {
        Log.d("Отработка onResume", "сработало")
        super.onResume()
        mainTextInput.setText("")
    }


}