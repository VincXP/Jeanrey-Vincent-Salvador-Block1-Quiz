package com.example.jeanreyvincentsalvador_block1_quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private var operand1: Double = 0.0
    private var operator: String? = null
    private var isNewOperation: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)
    }

    fun onDigitClick(view: View) {
        if (isNewOperation) {
            resultTextView.text = ""
            isNewOperation = false
        }

        val digit = (view as Button).text.toString()
        resultTextView.append(digit)
    }

    fun onOperatorClick(view: View) {
        operand1 = resultTextView.text.toString().toDouble()
        operator = (view as Button).text.toString()
        isNewOperation = true
    }

    fun onEqualClick(view: View) {
        val operand2 = resultTextView.text.toString().toDouble()
        var result = 0.0

        when (operator) {
            "+" -> result = operand1 + operand2
            "-" -> result = operand1 - operand2
            "*" -> result = operand1 * operand2
            "/" -> {
                if (operand2 != 0.0) {
                    result = operand1 / operand2
                } else {
                    resultTextView.text = "Error"
                    return
                }
            }
        }

        resultTextView.text = result.toString()
        isNewOperation = true
    }

    fun onClearClick(view: View) {
        resultTextView.text = ""
        operand1 = 0.0
        operator = null
        isNewOperation = true
    }
}