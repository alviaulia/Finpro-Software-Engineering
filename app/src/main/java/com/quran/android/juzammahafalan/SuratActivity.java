package com.quran.android.juzammahafalan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;

import java.util.List;

public class SuratActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surat);

        Intent intent = getIntent();
        Surat surat = (Surat) intent.getSerializableExtra("surat");
        String name = surat.getNama();
        List<Ayat> ayatList = surat.getAyatList();
        Fragment fragment = new SuratFragment(name, ayatList);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();



//        TextView suratName = findViewById(R.id.suratName);
//        suratName.setText(name);
    }


}