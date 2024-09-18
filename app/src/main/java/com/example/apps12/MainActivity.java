package com.example.apps12;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final long SPLASH_SCREEN_DELAY = 2000; // 2 detik

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Layout untuk splash screen jika ada

        // Menggunakan Handler untuk delay
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Cek status login
                SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
                boolean isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false);

                // Pindah ke aktivitas yang sesuai
                Intent intent;
                if (isLoggedIn) {
                    intent = new Intent(MainActivity.this, login.class);
                } else {
                    intent = new Intent(MainActivity.this, signup.class);
                }
                startActivity(intent);
                finish(); // Tutup MainActivity agar tidak bisa kembali
            }
        }, SPLASH_SCREEN_DELAY); // Menunggu 2 detik sebelum berpindah
    }
}
