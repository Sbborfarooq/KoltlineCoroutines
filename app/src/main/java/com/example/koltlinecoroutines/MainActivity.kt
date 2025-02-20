package com.example.koltlinecoroutines

import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Start the coroutine
        performBackgroundTask()



    }
    private fun performBackgroundTask() {
        // Launch a coroutine in the Main scope
        CoroutineScope(Dispatchers.Main).launch {
            Log.d("Coroutine", "Preparing to start the task...")

            // Switch to the IO dispatcher for background work
            val result = withContext(Dispatchers.IO) {
                Log.d("Coroutine", "Task started in background")
                for (i in 1..5) {
                    // Simulate a time-consuming task
                    delay(1000) // Delay for 1 second
                    Log.d("Coroutine", "Progress: ${i * 20}%")
                }
                "Task Completed!"
            }

            // Update the UI with the result
            Log.d("Coroutine", result) //####
        }
    }
}