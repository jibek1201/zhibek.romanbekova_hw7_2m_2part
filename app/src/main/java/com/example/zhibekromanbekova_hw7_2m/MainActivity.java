package com.example.zhibekromanbekova_hw7_2m;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zhibekromanbekova_hw7_2m.R;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private Integer first, second, sum;
    private Boolean isOperationClick = false;
    private String operation;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        button = findViewById(R.id.button1);
    }

    public void onNumberClick(View view) {
        String text = ((MaterialButton) view).getText().toString();
        if (text.equals("AC")) {
            textView.setText("0");
            first = 0;
            second = 0;
        } else if (textView.getText().toString().equals("0") || isOperationClick) {
            textView.setText(text);
        } else {
            textView.append(text);
        }
        button.setVisibility(View.GONE);
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        button.setVisibility(View.GONE);
        if (view.getId() == R.id.btn_plus) {
            first = Integer.valueOf(textView.getText().toString());
            operation = "+";
        } else if (view.getId() == R.id.btn_minus) {
            first = Integer.valueOf(textView.getText().toString());
            operation = "-";
        } else if (view.getId() == R.id.btn_multiplication) {
            first = Integer.valueOf(textView.getText().toString());
            operation = "*";
        } else if (view.getId() == R.id.btn_division) {
            first = Integer.valueOf(textView.getText().toString());
            operation = "/";
        } else if (view.getId() == R.id.equals) {
            second = Integer.valueOf(textView.getText().toString());
            if (operation.equals("+")) {
                sum = first + second;
                textView.setText(sum.toString());
            } else if (operation.equals("-")) {
                sum = first - second;
                textView.setText(sum.toString());
            } else if (operation.equals("*")) {
                sum = first * second;
                textView.setText(sum.toString());
            } else if (operation.equals("/")) {
                if (second == 0) {
                    textView.setText("Error");
                } else {
                    sum = first / second;
                    textView.setText(sum.toString());
                }
            } else if (operation.equals("%")) {
                sum = first / 100 * second;
                textView.setText(sum.toString());
                button.setVisibility(View.VISIBLE);

                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        intent.putExtra("result", sum);
                        startActivity(intent);
                    }
                });
            }
        }
        isOperationClick = true;
    }
}
