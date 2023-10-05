package com.example.bodymassindexapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnCalc = findViewById(R.id.btnCalculate);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText w = findViewById(R.id.editWeight);
                EditText h = findViewById(R.id.editHeight);

                if(!w.getText().toString().isEmpty() && !h.getText().toString().isEmpty() ){
                    try{
                        float weight = Integer.parseInt(w.getText().toString());
                        float height = Integer.parseInt(h.getText().toString());
                        if(weight > 20 && weight < 200 && height > 80 && height < 300) {
                            float hm = (height / 100.00f);
                            float cal = weight / (hm * hm);
                            BigDecimal bmi = new BigDecimal(cal).setScale(2, RoundingMode.HALF_UP);
                            String result = String.valueOf(bmi);
                            Intent showCalc = new Intent(MainActivity.this,ShowCalc.class);
                            showCalc.putExtra("res", result);
                            startActivity(showCalc);
                            finish();
                        }else{
                            Toast error = Toast.makeText(MainActivity.this,"Invalid Input",Toast.LENGTH_LONG);
                            error.show();
                        }

                    }
                    catch (Error error){
                        throw error;
                    }
                }
            }
        });
    }
}