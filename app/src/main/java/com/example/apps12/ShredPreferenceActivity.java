package com.example.apps12;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ShredPreferenceActivity extends AppCompatActivity {

    // Deklarasi variabel UI dan SharedPreferences
    private EditText editTextKey; // EditText untuk memasukkan kunci
    private EditText editTextValue; // EditText untuk memasukkan nilai
    private TextView textViewResult; // TextView untuk menampilkan hasil
    private SharedPreferences sharedPreferences; // SharedPreferences untuk menyimpan data

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Menetapkan layout XML untuk aktivitas ini
        setContentView(R.layout.activity_shred_preference);

        // Menghubungkan variabel UI dengan elemen di layout XML
        editTextKey = findViewById(R.id.editTextKey);
        editTextValue = findViewById(R.id.editTextValue);
        textViewResult = findViewById(R.id.textViewResult);

        // Menghubungkan tombol dengan aksi klik
        Button buttonSave = findViewById(R.id.buttonSave);
        Button buttonLoad = findViewById(R.id.buttonLoad);

        // Mengambil instance SharedPreferences dengan nama "MyPrefs" dan mode private
        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

        // Menetapkan listener untuk tombol Save
        buttonSave.setOnClickListener(v -> {
            // Mengambil kunci dan nilai dari EditText
            String key = editTextKey.getText().toString();
            String value = editTextValue.getText().toString();

            // Mendapatkan editor untuk SharedPreferences
            SharedPreferences.Editor editor = sharedPreferences.edit();
            // Menyimpan kunci dan nilai ke SharedPreferences
            editor.putString(key, value);
            // Menyimpan perubahan secara asinkron
            editor.apply();
            // Menampilkan pesan "Saved!" di TextView
            textViewResult.setText("Saved!");
        });

        // Menetapkan listener untuk tombol Load
        buttonLoad.setOnClickListener(v -> {
            // Mengambil kunci dari EditText
            String key = editTextKey.getText().toString();
            // Mengambil nilai yang disimpan dari SharedPreferences atau pesan default jika tidak ada
            String value = sharedPreferences.getString(key, "No data found");
            // Menampilkan nilai yang diambil di TextView
            textViewResult.setText(value);
        });
    }
}
