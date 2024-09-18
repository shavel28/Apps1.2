// MainMenuActivity.java
package com.example.apps12;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.apps12.OlahragaActivity;

public class MainMenuActivity extends AppCompatActivity {

    private Button btnToOlahraga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        // Inisialisasi tombol untuk detail olahraga
        btnToOlahraga = findViewById(R.id.btnToOlahraga);

        btnToOlahraga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent untuk pindah ke OlahragaActivity
                Intent intent = new Intent(MainMenuActivity.this, OlahragaActivity.class);
                intent.putExtra("OLAH_RAGA", "Detail tentang Olahraga ()"); // Mengirimkan data
                startActivity(intent);
            }
        });
    }
}
