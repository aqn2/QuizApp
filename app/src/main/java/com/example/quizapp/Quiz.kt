package com.example.quizapp

import android.widget.Toast

class Quiz(var questions : List<Question>) {
    var score = 0
    var currentQ = 0

    var qQuestion = questions[currentQ].question.toString()
    var qAnswers = questions[currentQ].answers
    var qCorrectAnswer = questions[currentQ].correctAnswer.toString()

    //make a function to check if answer is right and update score
    fun grade(answer : String): Boolean{
        if(answer == qCorrectAnswer){
            score ++
            currentQ ++
            return true
        }
        else{
            currentQ ++
            return false
        }
    }

    fun checkIndex(): Boolean{
        return currentQ == 20
    }

    fun questionText(): String{
        return questions[currentQ].question
    }
    fun answer1Text(): String{
        return questions[currentQ].answers[0]
    }
    fun answer2Text(): String{
        return questions[currentQ].answers[1]
    }
    fun answer3Text(): String{
        return questions[currentQ].answers[2]
    }
    fun answer4Text(): String{
        return questions[currentQ].answers[3]
    }


}