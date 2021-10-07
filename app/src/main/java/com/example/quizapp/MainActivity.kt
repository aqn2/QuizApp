package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"
    lateinit var quiz : Quiz
    lateinit var qDisplay : TextView
    lateinit var q1Display : Button
    lateinit var q2Display : Button
    lateinit var q3Display : Button
    lateinit var q4Display : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputStream = resources.openRawResource(R.raw.questions)
        val jsonText = inputStream.bufferedReader().use {
            it.readText()
        }
        Log.d(TAG, "oncreate: $jsonText")

        val gson = Gson()
        val type = object : TypeToken<List<Question>>() { }.type
        val questions = gson.fromJson<List<Question>>(jsonText, type)
        Log.d(TAG, "onCreate: \n${questions.toString()}")

        quiz = Quiz(questions)

        wireWidgets()


    }

    private fun wireWidgets() {
        qDisplay = findViewById(R.id.main_question_display)
        q1Display = findViewById(R.id.main_answer1)
        q2Display = findViewById(R.id.main_answer2)
        q3Display = findViewById(R.id.main_answer3)
        q4Display = findViewById(R.id.main_answer4)

    }


}