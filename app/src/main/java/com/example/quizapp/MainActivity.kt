package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
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

    lateinit var  display50 : ImageView
    lateinit var  display35 : ImageView
    lateinit var  display20 : ImageView
    lateinit var  display10 : ImageView
    lateinit var  display0: ImageView
    lateinit var finalText : TextView

    var answer = ""


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

        setNextQuestion()


        q1Display.setOnClickListener{
            answer = q1Display.text.toString()
            checkAnswerAndUpdateUI(answer)
        }
        q2Display.setOnClickListener{
            answer = q2Display.text.toString()
            checkAnswerAndUpdateUI(answer)
        }
        q3Display.setOnClickListener{
            answer = q3Display.text.toString()
            checkAnswerAndUpdateUI(answer)
        }
        q4Display.setOnClickListener{
            answer = q4Display.text.toString()
            checkAnswerAndUpdateUI(answer)
        }


    }

    private fun wireWidgets() {
        qDisplay = findViewById(R.id.main_question_display)
        q1Display = findViewById(R.id.main_answer1)
        q2Display = findViewById(R.id.main_answer2)
        q3Display = findViewById(R.id.main_answer3)
        q4Display = findViewById(R.id.main_answer4)
        display50 = findViewById(R.id.final_god_display)
            display50.visibility = View.GONE
        display35 = findViewById(R.id.frying_pan_drying_pan)
            display35.visibility = View.GONE
        display20 = findViewById(R.id.champion_craft)
            display20.visibility = View.GONE
        display10 = findViewById(R.id.bald_ketchum)
            display10.visibility = View.GONE
        display0 = findViewById(R.id.youngster_swoley)
            display0.visibility = View.GONE
        finalText = findViewById(R.id.main_final_text)
            finalText.visibility = View.GONE

    }

    private fun checkAnswerAndUpdateUI(answer: String){
        val response = quiz.grade(answer)

        if(response){
            Toast.makeText(this@MainActivity,"Correcto Expresso", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this@MainActivity,"Cubchoooooo?", Toast.LENGTH_SHORT).show()
        }

        setNextQuestion()
    }

    private fun setNextQuestion() {
        if(quiz.checkIndex()){
            showFinalText()
        }
        else{
            qDisplay.text = quiz.questionText()
            q1Display.text = quiz.answer1Text()
            q2Display.text = quiz.answer2Text()
            q3Display.text = quiz.answer3Text()
            q4Display.text = quiz.answer4Text()
        }

    }

    private fun showFinalText() {
        hideAllStuff()

        var total = quiz.getFinalScore()

        if(total == 50){
            display50.visibility = View.VISIBLE
            finalText.text = getString(R.string.main_score) + quiz.score + "\n" + getString(R.string.main_50result)
            finalText.visibility = View.VISIBLE

        }
        else if(total > 35){
            display35.visibility = View.VISIBLE
            finalText.text = getString(R.string.main_score) + quiz.score + "\n" + getString(R.string.main_35result)
            finalText.visibility = View.VISIBLE
        }
        else if(total > 20){
            display20.visibility = View.VISIBLE
            finalText.text = getString(R.string.main_score) + quiz.score + "\n" + getString(R.string.main_20result)
            finalText.visibility = View.VISIBLE
        }
        else if(total > 10){
            display10.visibility = View.VISIBLE
            finalText.text = getString(R.string.main_score) + quiz.score + "\n" + getString(R.string.main_10result)
            finalText.visibility = View.VISIBLE
        }
        else{
            display0.visibility = View.VISIBLE
            finalText.text = getString(R.string.main_score) + quiz.score + "\n" + getString(R.string.main_0result)
            finalText.visibility = View.VISIBLE
        }

    }

    private fun hideAllStuff() {
        qDisplay.visibility = View.INVISIBLE
        q1Display.visibility = View.INVISIBLE
        q2Display.visibility = View.INVISIBLE
        q3Display.visibility = View.INVISIBLE
        q4Display.visibility = View.INVISIBLE

    }


}