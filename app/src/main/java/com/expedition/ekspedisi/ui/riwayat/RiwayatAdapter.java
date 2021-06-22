package com.expedition.ekspedisi.ui.riwayat;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.expedition.ekspedisi.R;
import com.expedition.ekspedisi.data.riwayat.Riwayat;
import com.expedition.ekspedisi.network.AppDatabase;

import java.util.ArrayList;

public class RiwayatAdapter extends RecyclerView.Adapter<RiwayatAdapter.ViewHolder> {
    //Deklarasi Variable
    private ArrayList<Riwayat> daftarRiwayat;
    private AppDatabase appDatabase;
    private Context context;


    public RiwayatAdapter(ArrayList<Riwayat> daftarRiwayat, Context context) {

        //Inisialisasi data
        this.daftarRiwayat = daftarRiwayat;
        this.context = context;
        appDatabase = Room.databaseBuilder(
                context.getApplicationContext(),
                AppDatabase.class, "dbRiwayat").allowMainThreadQueries().build();

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        //Deklarasi View yang akan digunakan
        private TextView kab_asal, kab_tujuan;
        private  int id;
        private CardView item;

        ViewHolder(View itemView) {
            super(itemView);
            kab_asal = itemView.findViewById(R.id.inputKotaAsal);
            kab_tujuan = itemView.findViewById(R.id.inputKotaTujuan);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Inisialisasi Layout Item untuk RecyclerView
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_main, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String getKab_asal = daftarRiwayat.get(position).getKab_asal();
        String getKab_tujuan = daftarRiwayat.get(position).getKab_tujuan();

        //Menampilkan data berdasarkan posisi Item dari RecyclerView
        holder.kab_asal.setText(getKab_asal);
        holder.kab_tujuan.setText(getKab_tujuan);

//        holder.item.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                context.startActivity(new Intent(context, DetailActivity.class).putExtra("data", daftarRiwayat.get(position)));
//                ((Activity)context).finish();
//            }
//        });

    }


    @Override
    public int getItemCount() {

        return daftarRiwayat.size();
    }





}
