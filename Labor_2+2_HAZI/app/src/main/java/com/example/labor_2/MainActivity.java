package com.example.labor_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textv;
    EditText editText;
    CheckBox checkBox;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d("Statusz: ", "MainActivity - onCreate");

        Button button = findViewById(R.id.buttonSAT);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActivityTwo.class);
                startActivity(intent);
            }
        });


        textv = findViewById(R.id.textViewMain);

        textv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textv.append("\n" + textv.getText().toString());
            }
        });

        editText = findViewById(R.id.editTextTextMAIN);
        checkBox = findViewById(R.id.checkBoxMain);
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("Statusz:", "onSaveInstanceState");
//        Kimentes a boundel-ba
        outState.putString("txtv", textv.getText().toString());

        outState.putString("etxt", editText.getText().toString());

        outState.putBoolean("chbx", checkBox.isChecked());

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("Statusz:", "onRestoreInstanceState");

        textv.setText(savedInstanceState.getString("txtv"));

        editText.setText(savedInstanceState.getString("etxt"));

        checkBox.setChecked(savedInstanceState.getBoolean("chbx"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Statusz: ", "MainActivity - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Statusz: ", "MainActivity - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Statusz: ", "MainActivity - onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Statusz: ", "MainActivity - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Statusz: ", "MainActivity - onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Statusz: ", "MainActivity - onDestroy");
    }
}
