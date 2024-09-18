// OlahragaActivity.java
package com.example.apps12;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class OlahragaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_olahraga);

        // Ambil data olahraga dari intent
        String detailOlahraga = getIntent().getStringExtra("OLAH_RAGA");

        // Tampilkan fragment DetailOlahragaFragment dan kirimkan data ke fragment
        loadFragment(DetailOlahragaFragment.newInstance(detailOlahraga, ""));
    }

    private void loadFragment(Fragment fragment) {
        // Muat fragment ke dalam FrameLayout
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}
