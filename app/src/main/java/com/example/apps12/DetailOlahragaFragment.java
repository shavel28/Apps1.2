package com.example.apps12;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class DetailOlahragaFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    public DetailOlahragaFragment() {
        // Diperlukan kosong konstruktor
    }

    public static DetailOlahragaFragment newInstance(String param1, String param2) {
        DetailOlahragaFragment fragment = new DetailOlahragaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate layout untuk fragment
        View view = inflater.inflate(R.layout.fragment_detail_olahraga, container, false);

        // Ambil TextView dan set data dari argumen
        TextView olahragaDetail = view.findViewById(R.id.olahragaDetail);
        olahragaDetail.setText(mParam1);

        // Set up button untuk navigasi
        Button buttonGpsSensor = view.findViewById(R.id.buttonGpsSensor);
        Button buttonShredPreference = view.findViewById(R.id.buttonShredPreference);

        buttonGpsSensor.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), GpsSensorActivity.class);
            startActivity(intent);
        });

        buttonShredPreference.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ShredPreferenceActivity.class);
            startActivity(intent);
        });

        return view;
    }
}
