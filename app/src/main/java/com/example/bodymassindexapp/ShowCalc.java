package com.example.bodymassindexapp;

import static java.lang.String.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class ShowCalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_calc);
        String res = getIntent().getStringExtra("res");
        TextView text = findViewById(R.id.bmi);
        text.setText(res);
        float bmi = Float.parseFloat(res);
        BMIGaugeView bmiGaugeView = findViewById(R.id.bmiGaugeView);
        bmiGaugeView.setBMIValue(bmi);
        TextView stateBMI = findViewById(R.id.state);
        if (bmi < 18.5) {
            stateBMI.setText("Underweight");
        } else if (bmi >= 18.5 && bmi < 24.9) {
            stateBMI.setText("Overweight");
        } else {
            stateBMI.setText("Obese");
        }
        Button fin = findViewById(R.id.btnFinish);
        fin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent main = new Intent(ShowCalc.this, MainActivity.class);
                startActivity(main);
            }
        });
    }
}