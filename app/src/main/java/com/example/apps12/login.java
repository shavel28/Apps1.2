package com.example.apps12;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    Button btnSignIn, btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Menghubungkan komponen dengan XML
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.pss);
        btnSignIn = findViewById(R.id.btnsignin);
        btnSignUp = findViewById(R.id.btnsignup);

        // Event handler untuk tombol Sign In
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mendapatkan input email dan password
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // Validasi input
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(login.this, "Email tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(login.this, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Login sukses
                if (email.equals("admin@.com") && password.equals("admin123")) {
                    Toast.makeText(login.this, "Login Berhasil", Toast.LENGTH_SHORT).show();

                    // Simpan status login di SharedPreferences
                    SharedPreferences sharedPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putBoolean("isLoggedIn", true); // Menyimpan status login
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                        editor.apply();
                    }

                    // Pindah ke halaman DashboardActivity
                    Intent intent = new Intent(login.this, dashboard.class);
                    startActivity(intent);
                    finish(); // Tutup halaman login
                } else {
                    Toast.makeText(login.this, "Email atau Password salah", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Event handler untuk tombol Sign Up
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Berpindah ke halaman sign up
                Intent intent = new Intent(login.this, signup.class);
                startActivity(intent);
            }
        });
    }
}
