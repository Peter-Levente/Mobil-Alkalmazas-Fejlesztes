package com.example.a4_hazi;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Integer[] flags_img = {R.drawable.eur,
            R.drawable.usa,
            R.drawable.gbr,
            R.drawable.aus,
            R.drawable.can,
            R.drawable.svi,
            R.drawable.dan,
            R.drawable.hun};

    String[] short_name = {"EUR", "USD", "GBP", "AUD", "CAD", "CHF", "DKK", "HUF"};

    String[] name = {"Euro",
            "Dolar american",
            "Lira sterlina",
            "Dolar australian",
            "Dolar canadian",
            "Franc elvetian",
            "Coroana daneza",
            "Forint maghiar"};

    String[] buys = {"4,4100 RON",
            "3,9750 RON",
            "6,1250 RON",
            "2,9600 RON",
            "3,0950 RON",
            "4,2300 RON",
            "0,5850 RON",
            "0,0136 RON"};

    String[] sells = {"4,5500 RON",
            "4,1450 RON",
            "6,3550 RON",
            "3,0600 RON",
            "3,2650 RON",
            "4,3300 RON",
            "0,6150 RON",
            "0,0146 RON"};


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

        ListView listView = findViewById(R.id.customListView);

        CustomListAdapter adapter = new CustomListAdapter(this, flags_img, short_name, name, buys, sells);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String money_name = name[position];
                String buy = buys[position];

                String message = "Pénznem: " + money_name + ", Vételi árfolyam: " + buy;

                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}