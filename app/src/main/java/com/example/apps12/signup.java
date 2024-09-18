package com.example.apps12;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    EditText editTextEmail, editTextPassword;
    Button btnSignupSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup); // Pastikan nama layout sesuai

        // Menghubungkan komponen dengan XML
        editTextEmail = findViewById(R.id.signupEmail);
        editTextPassword = findViewById(R.id.signupPassword);
        btnSignupSubmit = findViewById(R.id.btnSignupSubmit);

        // Event handler untuk tombol Submit pendaftaran
        btnSignupSubmit.setOnClickListener(v -> {
            String email = editTextEmail.getText().toString().trim();
            String password = editTextPassword.getText().toString().trim();

            // Validasi input pendaftaran
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(signup.this, "Email dan Password harus diisi", Toast.LENGTH_SHORT).show();
            } else {
                // Implementasikan logika pendaftaran di sini (misal simpan ke database)
                Toast.makeText(signup.this, "Pendaftaran Berhasil", Toast.LENGTH_SHORT).show();
                finish(); // Kembali ke halaman login setelah pendaftaran
            }
        });
    }
}
