package com.example.koltlinecoroutines

import android.content.ContentValues.TAG
import android.nfc.Tag
import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.coroutines.yield


class MainActivity : AppCompatActivity() {
    private val TAG:String="MainActivity"
    override  fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Start the coroutine
        //Creating first coroutine function
        CoroutineScope(Dispatchers.Main).launch {task1()  }
        CoroutineScope(Dispatchers.Main).launch {task2()  }



    }




    //here we have two function named with task1 and task2
    suspend fun task1(){
        Log.d(TAG,"Starting Task1")
        yield()//suspension point
        Log.d(TAG,"Ending Task1")
    }

    suspend fun task2(){
        Log.d(TAG,"Starting Task2")
        yield()//suspension point
        Log.d(TAG,"Ending Task2")
    }
}