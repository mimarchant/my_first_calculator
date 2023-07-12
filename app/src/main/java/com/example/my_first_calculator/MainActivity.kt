package com.example.my_first_calculator

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val addButton = findViewById<Button>(R.id.addBtn)
        val substractButton = findViewById<Button>(R.id.substractBtn)
        val divideButton = findViewById<Button>(R.id.divideBtn)
        val multiplyButton = findViewById<Button>(R.id.multiplyBtn)
        val numero1 = findViewById<EditText>(R.id.numero1)
        val numero2 = findViewById<EditText>(R.id.numero2)
        val resultText = findViewById<TextView>(R.id.result)
        val inputManager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        addButton.setOnClickListener(View.OnClickListener {
            if (numero1.text.toString().isEmpty() || numero2.text.toString().isEmpty()) {
                Toast.makeText(baseContext, "falta un numero", Toast.LENGTH_LONG).show()
                return@OnClickListener
            }
            val num1 = numero1.text.toString().toInt()
            val num2 = numero2.text.toString().toInt()
            val result = calculate(num1, num2, 1)
            resultText.text = "El resultado es: $result"
        })
        substractButton.setOnClickListener(View.OnClickListener {
            if (numero1.text.toString().isEmpty() || numero2.text.toString().isEmpty()) {
                Toast.makeText(baseContext, "falta un numero", Toast.LENGTH_LONG).show()
                return@OnClickListener
            }
            val num1 = numero1.text.toString().toInt()
            val num2 = numero2.text.toString().toInt()
            val result = calculate(num1, num2, 2)
            resultText.text = "El resultado es: $result"
        })
        multiplyButton.setOnClickListener(View.OnClickListener {
            if (numero1.text.toString().isEmpty() || numero2.text.toString().isEmpty()) {
                Toast.makeText(baseContext, "falta un numero", Toast.LENGTH_LONG).show()
                return@OnClickListener
            }
            val num1 = numero1.text.toString().toInt()
            val num2 = numero2.text.toString().toInt()
            val result = calculate(num1, num2, 4)
             resultText.text = "El resultado es: $result"
        })
        divideButton.setOnClickListener(View.OnClickListener {
            if (numero1.text.toString().isEmpty() || numero2.text.toString().isEmpty()) {
                Toast.makeText(baseContext, "falta un numero", Toast.LENGTH_LONG).show()
                return@OnClickListener
            }
            val num1 = numero1.text.toString().toInt()
            val num2 = numero2.text.toString().toInt()
            val result = calculate(num1, num2, 3)
             resultText.text = "El resultado es: $result"
        })
    }

    private fun calculate(num1: Int, num2: Int, operand: Int): Int {
        var result = 0
        when (operand) {
            1 -> result = num1 + num2
            2 -> result = num1 - num2
            3 -> {
                if (num2 == 0) {
                    Toast.makeText(baseContext, "no se puede dividir por 0", Toast.LENGTH_LONG).show()
                    throw IllegalArgumentException("no se puede dividir por 0")
                }
                result = num1 / num2
            }

            4 -> result = num1 * num2
        }
        return result
    }
}