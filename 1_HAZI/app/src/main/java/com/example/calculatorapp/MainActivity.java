package com.example.calculatorapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button plusz = findViewById(R.id.plusz);
        Button minusz = findViewById(R.id.minusz);
        Button szorzas = findViewById(R.id.szorzas);
        Button osztas = findViewById(R.id.osztas);
        EditText szam1 = findViewById(R.id.szam1);
        EditText szam2 = findViewById(R.id.szam2);
        TextView result = findViewById(R.id.result);


        plusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double osszeg = Double.parseDouble(szam1.getText().toString()) + Double.parseDouble(szam2.getText().toString());
                result.setText(String.valueOf(osszeg));
            }
        });

        minusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double osszeg = Double.parseDouble(szam1.getText().toString()) - Double.parseDouble(szam2.getText().toString());
                result.setText(String.valueOf(osszeg));
            }
        });

        szorzas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double osszeg = Double.parseDouble(szam1.getText().toString()) * Double.parseDouble(szam2.getText().toString());
                result.setText(String.valueOf(osszeg));
            }
        });

        osztas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double osszeg = Double.parseDouble(szam1.getText().toString()) / Double.parseDouble(szam2.getText().toString());
                result.setText(String.valueOf(osszeg));
            }
        });
    }
}