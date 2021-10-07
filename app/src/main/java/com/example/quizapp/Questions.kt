package com.example.quizapp

data class Question(
    var category : String,
    var question : String,
    var answers : List<String>,
    var correctAnswer : String
    )