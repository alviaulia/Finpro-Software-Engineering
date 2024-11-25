package com.quran.android.juzammahafalan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SuratAdapter extends RecyclerView.Adapter<SuratAdapter.ViewHolder>{

    private List<Surat> suratList;
    private OnItemClickListener onItemClickListener;

    public SuratAdapter(List<Surat> suratList, OnItemClickListener onItemClickListener) {
        this.suratList = suratList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.noSurat.setText(String.valueOf(suratList.get(position).getNomor()));
        holder.namaSurat.setText(suratList.get(position).getNama());
        holder.jumlahAyat.setText(String.valueOf(suratList.get(position).getJumlahAyat()));
        holder.bind(suratList.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return (suratList != null) ? suratList.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView noSurat, namaSurat, jumlahAyat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            noSurat = itemView.findViewById(R.id.noSurat);
            namaSurat = itemView.findViewById(R.id.namaSurat);
            jumlahAyat = itemView.findViewById(R.id.jumlahAyat);
        }

        public void bind(Surat item, OnItemClickListener onItemClickListener) {
            itemView.setOnClickListener(v -> {
                onItemClickListener.onItemClick(item);
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Surat surat);
    }
}
