package com.example.android.juzammahafalan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SuratAdapter adapter;
    private ArrayList<Surat> suratList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        adapter = new SuratAdapter(suratList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

    }

    private void addData() {
        suratList = new ArrayList<>();
        suratList.add(new Surat("An-Nas", 114, 6));
        suratList.add(new Surat("Al-Falaq", 113, 5));
        suratList.add(new Surat("Al-Ikhlas", 112, 4));
        suratList.add(new Surat("Al-Lahab", 111, 5));
        suratList.add(new Surat("An-Nasr", 110, 3));
        suratList.add(new Surat("Al-Kafirun", 109, 6));
        suratList.add(new Surat("Al-Kausar", 108, 3));
        suratList.add(new Surat("Al-Maun", 107, 7));
    }
}