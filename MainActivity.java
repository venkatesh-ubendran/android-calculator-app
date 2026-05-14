package com.example.calculatorapp;

import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button add, sub, mul, div, clear;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result);

        add = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        clear = findViewById(R.id.clear);

        add.setOnClickListener(v -> calculate('+'));
        sub.setOnClickListener(v -> calculate('-'));
        mul.setOnClickListener(v -> calculate('*'));
        div.setOnClickListener(v -> calculate('/'));
        clear.setOnClickListener(v -> {
            num1.setText("");
            num2.setText("");
            result.setText("Result");
        });
    }

    private void calculate(char op) {

        if(num1.getText().toString().isEmpty() || num2.getText().toString().isEmpty()){
            result.setText("Enter both numbers");
            return;
        }

        double n1 = Double.parseDouble(num1.getText().toString());
        double n2 = Double.parseDouble(num2.getText().toString());
        double res = 0;

        if(op == '+') res = n1 + n2;
        else if(op == '-') res = n1 - n2;
        else if(op == '*') res = n1 * n2;
        else if(op == '/') res = n1 / n2;

        result.setText("Result: " + res);
    }
}