package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeightFt, edtHeightIn;
        Button calculateBtn;
        TextView txvResult;
        LinearLayout llMain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);

        calculateBtn = findViewById(R.id.calculateBtn);

        txvResult = findViewById(R.id.txvResult);

        llMain = findViewById(R.id.llMain);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int weight = Integer.parseInt(edtWeight.getText().toString());
                int heightFt = Integer.parseInt(edtHeightFt.getText().toString());
                int heightInch = Integer.parseInt(edtHeightIn.getText().toString());

                int totalHeightInInch = heightFt * 12 + heightInch;
                double totalHeightInMeter = totalHeightInInch / 39.37; // meter = inch/39.37

                double bmi = weight / (totalHeightInMeter * totalHeightInMeter);

                if (bmi > 25) {
                    txvResult.setText("You are overweight!");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
                }else if (bmi < 18) {
                    txvResult.setText("You are underweight!");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorUW));

                }else {
                    txvResult.setText("You are healthy <3 !!!");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorHL));
                }
            }
        });
    }
}