package com.example.apps12;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class dashboard extends AppCompatActivity {

    // Data untuk AutoCompleteTextView dan Spinner
    String[] olahragaList = {"Sepak Bola", "Basket", "Tenis", "Bulu Tangkis", "Voli"};
    String[] kategoriList = {"1 JAM", "2 JAM", "3 JAM", "4 JAM", "5 JAM", "6 JAM"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Menghubungkan komponen dengan XML
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.pencarian);
        Spinner spinner = findViewById(R.id.spinner);
        ListView listView = findViewById(R.id.listView);
        Button btnNext = findViewById(R.id.btnNext); // Tambahkan referensi untuk button

        // Adapter untuk AutoCompleteTextView
        ArrayAdapter<String> autoCompleteAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, olahragaList);
        autoCompleteTextView.setAdapter(autoCompleteAdapter);

        // Adapter untuk Spinner
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, kategoriList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        // Adapter untuk ListView
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, olahragaList);
        listView.setAdapter(listAdapter);

        // Event handler untuk item yang dipilih pada ListView
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedOlahraga = olahragaList[position];
            Toast.makeText(dashboard.this, "Olahraga dipilih: " + selectedOlahraga, Toast.LENGTH_SHORT).show();
        });

        // Event handler untuk Button Next
        btnNext.setOnClickListener(v -> {
            // Intent untuk pindah ke MainMenuActivity
            Intent intent = new Intent(dashboard.this, MainMenuActivity.class);
            startActivity(intent);
        });
    }
}
