package com.expedition.ekspedisi.ui.riwayat;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.expedition.ekspedisi.R;
import com.expedition.ekspedisi.data.riwayat.Riwayat;
import com.expedition.ekspedisi.network.AppDatabase;
import com.expedition.ekspedisi.ui.search.SearchCityActivity;

public class
InsertActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText kab_asal, kab_tujuan;
    private AppDatabase database;
    private Button btnTambah, btnListLagu;
    private int id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_ongkir);

        kab_asal = findViewById(R.id.inputKotaAsal);
        kab_tujuan = findViewById(R.id.inputKotaTujuan);

        database = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "dbRiwayat") //Nama File Database yang akan disimpan
                .build();
    }


    private void insertRiwayat(final Riwayat riwayat){
        new AsyncTask<Void, Void, Long>() {
            @Override
            protected Long doInBackground(Void... voids) {
                //Menjalankan proses insert data
                long status = database.riwayatDAO().insertRiwayat(riwayat);
                return status;
            }

        }.execute();
    }



        @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnSubmit :
                if (kab_asal.getText().toString().isEmpty()){
                    Toast.makeText(InsertActivity.this, "Form tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else if (kab_tujuan.getText().toString().isEmpty()){
                    Toast.makeText(InsertActivity.this, "Form tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    Riwayat dataRiwayat = new Riwayat();
                    //memasukkan data input ke dalam database
                    dataRiwayat.setId(id);
                    dataRiwayat.setKab_asal(kab_asal.getText().toString());
                    dataRiwayat.setKab_tujuan(kab_tujuan.getText().toString());
                    insertRiwayat(dataRiwayat);

                    //Reset edit text
                    kab_asal.setText("");
                    kab_tujuan.setText("");
                }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
