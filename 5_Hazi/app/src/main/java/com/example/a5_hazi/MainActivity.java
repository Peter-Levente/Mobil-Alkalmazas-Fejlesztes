package com.example.a5_hazi;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView myListView;
    ArrayList<String> stringList;
    ArrayAdapter<String> myAdapter;


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

        myListView = findViewById(R.id.lista_nezet);
        stringList = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.elemek)));

        myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, stringList);
        myListView.setAdapter(myAdapter);
        registerForContextMenu(myListView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        TextView selectedView = (TextView) myListView.getChildAt(info.position);

        if (selectedView != null) {
            if (item.getItemId() == R.id.red) {
                selectedView.setTextColor(Color.RED);
            } else if (item.getItemId() == R.id.green) {
                selectedView.setTextColor(Color.GREEN);
            } else if (item.getItemId() == R.id.yellow) {
                selectedView.setTextColor(Color.YELLOW);
            }
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.sortabc) {
            sortList();
            return true;
        } else if (itemId == R.id.delete) {
            clearList();
            return true;
        }
        return true;
    }

    private void sortList() {
        Collections.sort(stringList); // A stringList rendezése
        myAdapter.notifyDataSetChanged(); // Adapter értesítése a változásról
    }

    private void clearList() {
        stringList.clear();
        myAdapter.notifyDataSetChanged();
    }
}