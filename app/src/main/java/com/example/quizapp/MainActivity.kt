package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    val inputStream = resources.openRawResource(R.raw.students)
    val jsonText = inputStream.bufferedReader().use {
        it.readText()
    }
    Log.d(TAG, "oncreate: $jsonText")

    val gson = Gson()
    val type = object : TypeToken<List<Question>>() { }.type
    val questions = gson.fromJson<List<Question>>(jsonText, type)
    Log.d(TAG, "onCreate: \n${questions.toString()}")

    }

    data class Question{


}