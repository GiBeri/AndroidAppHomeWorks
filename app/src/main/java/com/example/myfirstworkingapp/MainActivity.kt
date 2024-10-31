package com.example.myfirstworkingapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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

        val enterNameInput = findViewById<EditText>(R.id.EnterName)
        val okayButton = findViewById<Button>(R.id.OkayBtn)
        val nameOutput = findViewById<TextView>(R.id.TextView1)

        okayButton.setOnClickListener {
            val inputText = enterNameInput.text.toString()
            if (inputText == ""){
                nameOutput.text = "Hello!"
                Toast.makeText(this, "Enter Name!", Toast.LENGTH_SHORT).show()
            }
            else {
                nameOutput.text = "Hello, " + inputText + "!"
            }
        }

        val nextButton = findViewById<Button>(R.id.NextBtn)
        nextButton.setOnClickListener {
            val Intent = Intent(this, MainActivity2::class.java)
            startActivity(Intent)
        }
    }
}