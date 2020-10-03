package com.example.android.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;
import android.widget.Button;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
    String operator = ".";
    double answer = 0;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.answer);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAnswer();
            }
        });
    }
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.plus:
                operator = "+";
                break;
            case R.id.minus:
                operator = "-";
                break;
            case R.id.multiply:
                operator = "*";
                break;
            case R.id.divide:
                operator = "/";
                break;
        }
    }

    public void findAnswer(String operator) {
        EditText a1 = (EditText) findViewById(R.id.number1);
        EditText b1 = (EditText) findViewById(R.id.number2);
        if (a1.getText().toString().matches("") || b1.getText().toString().matches("")) {
            answer = 0;
            Toast.makeText(this, "Number fields should be filled", Toast.LENGTH_SHORT).show();
        } else {
            double a = Double.parseDouble(a1.getText().toString());
            double b = Double.parseDouble(b1.getText().toString());

            if (operator.equals("/") && b == 0) {
                answer = 0;
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
            } else if (operator.equals(".")) {
                answer = 0;
                Toast.makeText(this, "Operator is not chosen", Toast.LENGTH_SHORT).show();
            } else {
                switch (operator) {
                    case "+":
                        answer = a + b;
                        break;
                    case "-":
                        answer = a - b;
                        break;
                    case "*":
                        answer = a * b;
                        break;
                    case "/":
                        answer = a / b;
                        break;
                }
            }
        }
    }

    public void openAnswer() {
        findAnswer(operator);
        Intent intent = new Intent(this, activity_answer.class);
        intent.putExtra("key", String.valueOf(answer));
        startActivity(intent);
    }

}