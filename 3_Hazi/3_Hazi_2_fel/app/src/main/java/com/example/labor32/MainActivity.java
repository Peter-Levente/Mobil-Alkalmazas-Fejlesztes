package com.example.labor32;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Product> products = new ArrayList<>();
    TextView products_Tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = findViewById(R.id.p_name);
        EditText code = findViewById(R.id.p_code);
        EditText price = findViewById(R.id.p_price);
        Button add_p = findViewById(R.id.add_p_btn);
        Button cancel = findViewById(R.id.remove_p_btn);
        Button show_p = findViewById(R.id.show_p);
        products_Tv = findViewById(R.id.product_Tv);

        add_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productName = name.getText().toString();
                String productCode = code.getText().toString();
                String productPriceStr = price.getText().toString();


                if (productName == null || productName.equals("")) {
                    Toast.makeText(MainActivity.this, "Hianyzik a termek neve!", Toast.LENGTH_SHORT).show();
                } else if (productCode == null || productName.equals("")) {
                    Toast.makeText(MainActivity.this, "Hianyzik a termek kodja!", Toast.LENGTH_SHORT).show();
                } else if (productPriceStr == null || productPriceStr.equals("")) {
                    Toast.makeText(MainActivity.this, "Hianyzik a termek ara!", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        Double productPrice = Double.parseDouble(productPriceStr);
                        Product product = new Product(productCode, productName, productPrice);
                        products.add(product);

                        Toast.makeText(MainActivity.this, "Termek hozzadva!", Toast.LENGTH_SHORT).show();

                        name.setText("");
                        code.setText("");
                        price.setText("");
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Nem szamot adott meg arnak!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                code.setText("");
                price.setText("");
            }
        });

        show_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String productDetails = "";

                for (Product product : products) {
                    productDetails += "Kod: " + product.getCode() + ", Nev: " + product.getName() + ", Ar: " + product.getPrice() + "\n";
                }
                products_Tv.setText(productDetails);
            }
        });
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        ArrayList<String> productStrings = new ArrayList<>();

        for (Product product : products) {
            productStrings.add("Kod: " + product.getCode() + ", Nev: " + product.getName() + ", Ar: " + product.getPrice() + "\n");
        }

        outState.putStringArrayList("product_list", productStrings);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        ArrayList<String> productStrings = savedInstanceState.getStringArrayList("product_list");
        products.clear();

        if (productStrings != null) {
            for (String productString : productStrings) {
                String[] parts = productString.split(", ");
                if (parts.length==3){
                    String code=parts[0].split(": ")[1];
                    String name=parts[1].split(": ")[1];
                    Double price=Double.parseDouble(parts[2].split(": ")[1]);
                    products.add(new Product(code,name,price));
                }
            }
        }
        showProductsInTextView();
    }

    private void showProductsInTextView() {
        String productDetails = "";

        for (Product product : products) {
            productDetails += "Kod: " + product.getCode() + ", Nev: " + product.getName() + ", Ar: " + product.getPrice() + "\n";
        }
        products_Tv.setText(productDetails);
    }
}