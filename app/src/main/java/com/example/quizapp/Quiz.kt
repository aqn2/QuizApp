package com.example.quizapp

import android.widget.Toast

class Quiz(var questions : List<Question>) {
    var score = 0
    var currentQ = 0

    //make a function to check if answer is right and update score
    fun grade(answer : String): Boolean{
        var pointValue = 0
        if(questions[currentQ].category.equals("Easy")){
            pointValue = 1
        }
        else if(questions[currentQ].category.equals("Medium")){
            pointValue = 2
        }
        else if(questions[currentQ].category.equals("MediumHard")){
            pointValue = 3
        }
        else{
            pointValue = 4
        }


        if(answer.equals(questions[currentQ].correctAnswer.toString())){
            score += pointValue
            currentQ ++
            return true
        }
        else{
            currentQ ++
            return false
        }
    }

    fun checkIndex(): Boolean{
        return (currentQ == 20)
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

    fun getFinalScore(): Int{
        return score
    }


}