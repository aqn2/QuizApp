package com.example.quizapp

import android.widget.Toast

class Quiz(var questions : List<Question>) {
    var score = 0
    var currentQ = 0

    //make a function to check if answer is right and update score
    fun grade(answer : String){
        if(answer.equals(questions[currentQ])){
            score ++
            currentQ ++
        }
        else{
            currentQ ++
        }
    }

    fun nextQuestion(){
        if((currentQ < questions.size-1)){
            displayNext()
        }
        else{
           //do something
        }
    }

    fun displayNext(){
        qDisplay.text
    }


}