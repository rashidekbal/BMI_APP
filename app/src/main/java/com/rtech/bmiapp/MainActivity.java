package com.rtech.bmiapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText Age,height,weight;
        Button calculate;
        TextView result,ideal_weight,Fat;
        result=findViewById(R.id.result_txt);
        ideal_weight=findViewById(R.id.Ideal_weight_text);
        Fat=findViewById(R.id.fat_txt);
        Age=findViewById(R.id.age_input);
        height=findViewById(R.id.height_input);
        weight=findViewById(R.id.weight_input);
        DecimalFormat df = new DecimalFormat("#.0");
        calculate=findViewById(R.id.Calculate_btn);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float age=Float.parseFloat(Age.getText().toString());
                float heightInM=(Float.parseFloat(height.getText().toString()))/100;
                float Weight=Float.parseFloat(weight.getText().toString());
                float bmi = Weight/(heightInM*heightInM);
//                float IdealWeight=22*(heightInM*heightInM);
                float IdealWeight=50f+(2.3f*((Float.parseFloat(height.getText().toString()))-152.4f)/2.54f);
                float fat=1.20f*bmi+0.23f*age-16.2f;
                result.setText(df.format(bmi));
                ideal_weight.setText(df.format(IdealWeight)+"kG");
                Fat.setText(df.format(fat)+"%");
                Age.setText("");
                height.setText("");
                weight.setText("");



            }
        });
    }
}