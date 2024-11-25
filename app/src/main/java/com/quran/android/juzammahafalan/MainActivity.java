package com.quran.android.juzammahafalan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SuratAdapter adapter;
    private List<Surat> suratList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addData();
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        adapter = new SuratAdapter(suratList, (surat) -> {
            Intent intent = new Intent(this, SuratActivity.class);
//            intent.putExtra("suratName", surat.getNama());
//            intent.putExtra("ayatList", (Serializable) surat.getAyatList());
            intent.putExtra("surat", surat);

            startActivity(intent);
        });

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);

    }

    private void addData() {
//        suratList = new ArrayList<>();
//        suratList.add(new Surat("An-Nas", 114, 6, Arrays.asList(new Ayat("a", "a", "a"), new Ayat("b", "b", "b"))));
//        suratList.add(new Surat("Al-Falaq", 113, 5));
//        suratList.add(new Surat("Al-Ikhlas", 112, 4));
//        suratList.add(new Surat("Al-Lahab", 111, 5));
//        suratList.add(new Surat("An-Nasr", 110, 3));
//        suratList.add(new Surat("Al-Kafirun", 109, 6));
//        suratList.add(new Surat("Al-Kausar", 108, 3));
//        suratList.add(new Surat("Al-Maun", 107, 7));
//        suratList.add(new Surat("Al-Quraisy", 106, 4));
//        suratList.add(new Surat("Al-Fil", 105, 5));
//        suratList.add(new Surat("Al-Humazah", 104, 9));
//        suratList.add(new Surat("Al-Asr", 103, 3));
//        suratList.add(new Surat("Al-Takasur", 102, 8));
//        suratList.add(new Surat("Al-Qariah", 101, 11));
//        suratList.add(new Surat("Al-Adiyat", 100, 11));
//        suratList.add(new Surat("Al-Zalzalah", 99, 8));
//        suratList.add(new Surat("Al-Bayyinah", 98, 8));
//        suratList.add(new Surat("Al-Qadr", 97, 5));
//        suratList.add(new Surat("Al-Alaq", 96, 19));
//        suratList.add(new Surat("At-Tin", 95, 8));
//        suratList.add(new Surat("Al-Insyirah", 94, 8));
//        suratList.add(new Surat("Ad-Duha", 93, 11));
//        suratList.add(new Surat("Al-Lail", 92, 21));
//        suratList.add(new Surat("Al-Syams", 91, 15));
//        suratList.add(new Surat("Al-Balad", 90, 20));
//        suratList.add(new Surat("Al-Fajr", 89, 30));
//        suratList.add(new Surat("Al-Gassiyah", 88, 26));
//        suratList.add(new Surat("Al-A'la", 87, 19));
//        suratList.add(new Surat("At-Tariq", 86, 17));
//        suratList.add(new Surat("Al-Buruj", 85, 22));
//        suratList.add(new Surat("Al-Insyiqaq", 84, 25));
//        suratList.add(new Surat("Al-Mutaffifin", 83, 36));
//        suratList.add(new Surat("Al-Infithar", 82, 19));
//        suratList.add(new Surat("At-Takwir", 81, 29));
//        suratList.add(new Surat("Abasa", 80, 42));
//        suratList.add(new Surat("An-Naziat", 79, 46));
//        suratList.add(new Surat("An-Naba", 78, 40));

        InputStream is = getResources().openRawResource(R.raw.surat);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



//        Log.d("DEBUG JSON", jsonString);

        Gson gson = new Gson();
        String jsonString = writer.toString();
        Type type = new TypeToken<ArrayList<Surat>>(){}.getType();
        Surat[] arr = gson.fromJson(jsonString, Surat[].class);
        suratList = Arrays.asList(arr);
        Log.d("debug json", String.valueOf(arr[0].getAyatList().get(0).getAudio()));
    }

}