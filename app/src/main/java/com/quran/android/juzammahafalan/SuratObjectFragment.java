package com.quran.android.juzammahafalan;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SuratObjectFragment extends Fragment {
    public static final String ARG_OBJECT = "object";
    private int id = -1;
    private MediaPlayer mp;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.surat_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        Log.d("SURATOBJECT", "VIEW CREATED");
        if (args != null) {
            Ayat ayat = (Ayat) args.getSerializable("ayat");
            ((TextView) view.findViewById(R.id.text1))
                    .setText(ayat.getArabText());
            ((TextView) view.findViewById(R.id.text2))
                    .setText(ayat.getLatinText());
            ((TextView) view.findViewById(R.id.text3))
                    .setText(ayat.getTranslation());
            String audioRes = ayat.getAudio();
            if (audioRes != null) {
                id = getResources().getIdentifier(audioRes, "raw", "com.quran.android.juzammahafalan");
                ((Button) view.findViewById(R.id.audioButton)).setOnClickListener(v -> {
                    if (mp != null) {
                        mp.release();
                    }
                    mp = MediaPlayer.create(getContext(), id);
                    mp.start();
                    mp.setOnCompletionListener(MediaPlayer::release);
                });
            } else {
                ((Button) view.findViewById(R.id.audioButton)).setOnClickListener(v -> {
                    Toast.makeText(getContext(), "Audio not available", Toast.LENGTH_LONG).show();
                });
            }
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("SURATOBJECT", "RESUME " + String.valueOf(id));
        if (id != -1) {
            if (mp != null) {
                mp.release();
            }
            mp = MediaPlayer.create(getContext(), id);
            mp.start();
            mp.setOnCompletionListener(MediaPlayer::release);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("SURATOBJECT", "PAUSE");
        if (mp != null) {
            mp.release();
        }
    }
}
