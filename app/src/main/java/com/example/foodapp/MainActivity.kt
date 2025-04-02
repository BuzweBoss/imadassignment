package com.example.foodapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        //This is where i have declared all my variables that are used on the App
        val editTextMeal = findViewById<EditText>(R.id.editTextMeal)
        val buttonSuggest = findViewById<Button>(R.id.buttonSuggest)
        val buttonReset = findViewById<Button>(R.id.buttonReset)
        val textViewMealSuggestion = findViewById<TextView>(R.id.textViewMealSuggestion)


        //Here we have a button that will suggest what meal to have based on the time of day you have typed.
        buttonSuggest.setOnClickListener {
            val timeOfDay = editTextMeal.text.toString().trim()
            val suggestion = when (timeOfDay.lowercase()) {
                "breakfast" -> "Have a Spinach & Feta Omelette – Served with rye toast and grilled tomatoes."
                "lunch" -> "Have a Pasta Salad – Penne with cherry tomatoes, olives, basil, and mozzarella."
                "dinner" -> "Have Braai Meat Platter – With pap, chakalaka, and coleslaw (South African style)."
                "supper" -> "Have a light meal - Chicken Noodle Soup"

                else -> "Please enter the correct time of day"
                //We also have an error handler, when the user enters an incorrect meal time, it will prompt the user to enter correct time of day
                //Author:OpenaiChatGPT
                //url:https://chatgpt.com/c/67e8ef84-c0a8-8007-abde-b460d65b10b7
            }
            textViewMealSuggestion.text = suggestion
        }
        //Here we have a reset button that will clear all the information typed and suggested.
        //Author:Zahra Bulbulia
        buttonReset.setOnClickListener {
            editTextMeal.text.clear()
            textViewMealSuggestion.text = " "
        }

    }
}

