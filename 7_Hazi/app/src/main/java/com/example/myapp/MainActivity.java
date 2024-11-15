package com.example.myapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    String[] nameArray = {"Octopus", "Pig", "Sheep", "Rabbit", "Snake", "Spider", "Spider", "Spider", "Spider"};
    String[] infoArray = {"8 tentacled monster", "Delicious in rolls", "Great for jumpers", "Nice in a stew", "Great for shoes", "Scary", "Scary", "Scary", "Scary"};
    Integer[] imageArray = {R.drawable.cat, R.drawable.disznyo, R.drawable.dog, R.drawable.giraffe, R.drawable.horse, R.drawable.lion, R.drawable.octopus3, R.drawable.rabbit, R.drawable.sheep};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, nameArray, infoArray, imageArray);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
