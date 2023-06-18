package com.example.my_first_calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.view.inputmethod.InputMethodManager;
import android.content.Context;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton = findViewById(R.id.addBtn);
        Button substractButton = findViewById(R.id.substractBtn);
        Button divideButton = findViewById(R.id.divideBtn);
        Button multiplyButton = findViewById(R.id.multiplyBtn);

        EditText numero1 = findViewById(R.id.numero1);
        EditText numero2 = findViewById(R.id.numero2);
        TextView resultText = findViewById(R.id.result);

        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);




        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numero1.getText().toString().isEmpty() || numero2.getText().toString().isEmpty()){
                    Toast.makeText(getBaseContext(), "falta un numero", Toast.LENGTH_LONG).show();
                    return;
                }
                int num1 = Integer.parseInt(numero1.getText().toString());
                int num2 = Integer.parseInt(numero2.getText().toString());


                int result = calculate(num1, num2, 1);

                if(inputManager != null) {
                    View currentFocusedView = getCurrentFocus();
                    if (currentFocusedView != null) {
                        inputManager.hideSoftInputFromWindow(currentFocusedView.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    }
                }

                resultText.setText("El resultado es: " + result);
            }
        });

        substractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numero1.getText().toString().isEmpty() || numero2.getText().toString().isEmpty()){
                    Toast.makeText(getBaseContext(), "falta un numero", Toast.LENGTH_LONG).show();
                    return;
                }

                int num1 = Integer.parseInt(numero1.getText().toString());
                int num2 = Integer.parseInt(numero2.getText().toString());


                int result = calculate(num1, num2, 2);

                if(inputManager != null) {
                    View currentFocusedView = getCurrentFocus();
                    if (currentFocusedView != null) {
                        inputManager.hideSoftInputFromWindow(currentFocusedView.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    }
                }

                resultText.setText("El resultado es: " + result);
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numero1.getText().toString().isEmpty() || numero2.getText().toString().isEmpty()){
                    Toast.makeText(getBaseContext(), "falta un numero", Toast.LENGTH_LONG).show();
                    return;
                }

                int num1 = Integer.parseInt(numero1.getText().toString());
                int num2 = Integer.parseInt(numero2.getText().toString());


                int result = calculate(num1, num2, 4);

                if(inputManager != null) {
                    View currentFocusedView = getCurrentFocus();
                    if (currentFocusedView != null) {
                        inputManager.hideSoftInputFromWindow(currentFocusedView.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    }
                }

                resultText.setText("El resultado es: " + result);
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numero1.getText().toString().isEmpty() || numero2.getText().toString().isEmpty()){
                    Toast.makeText(getBaseContext(), "falta un numero", Toast.LENGTH_LONG).show();
                    return;
                }

                int num1 = Integer.parseInt(numero1.getText().toString());
                int num2 = Integer.parseInt(numero2.getText().toString());


                int result = calculate(num1, num2, 3);

                if(inputManager != null) {
                    View currentFocusedView = getCurrentFocus();
                    if (currentFocusedView != null) {
                        inputManager.hideSoftInputFromWindow(currentFocusedView.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                    }
                }

                resultText.setText("El resultado es: " + result);
            }
        });

    }

    private int calculate(int num1, int num2, int operand){
        int result = 0;
            switch (operand) {
                //sum
                case 1:
                    result = num1 + num2;
                    break;
                //subtraction
                case 2:
                    result = num1 - num2;
                    break;
                case 3:
                    if (num2 == 0) {
                        Toast.makeText(getBaseContext(), "no se puede dividir por 0", Toast.LENGTH_LONG).show();
                        break;
                    }
                    result = num1 / num2;
                    break;
                case 4:
                    result = num1 * num2;


            }
            
            return result;
    }
}