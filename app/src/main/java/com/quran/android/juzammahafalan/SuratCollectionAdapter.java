package com.quran.android.juzammahafalan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class SuratCollectionAdapter extends FragmentStateAdapter {
    private String suratName;
    private List<Ayat> ayatList;
    public SuratCollectionAdapter(Fragment fragment, String suratName, List<Ayat> ayatList) {
        super(fragment);
        this.suratName = suratName;
        this.ayatList = ayatList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Return a NEW fragment instance in createFragment(int)
        Fragment fragment = new SuratObjectFragment();
        Bundle args = new Bundle();
        // Our object is just an integer :-P
        args.putInt(SuratObjectFragment.ARG_OBJECT, position + 1);
        args.putSerializable("ayat", ayatList.get(position));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return ayatList.size();
    }
}
