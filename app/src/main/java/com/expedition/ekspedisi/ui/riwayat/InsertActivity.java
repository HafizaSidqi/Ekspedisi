package com.expedition.ekspedisi.ui.resi;

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

import com.expedition.ekspedisi.R;
import com.expedition.ekspedisi.data.resi.Resi;
import com.expedition.ekspedisi.network.AppDatabase;
import com.expedition.ekspedisi.ui.search.SearchCityActivity;

public class InsertActivity extends AppCompatActivity implements View.OnClickListener{

    private static final int REQUEST_SOURCE = 1;
    private static final int REQUEST_DESTINATION = 2;

    private EditText nmpengirim, tlppengirim, nmpenerima, almtpenerima, tlppenerima, kab_asal, kab_tujuan,
    barang, berat;
    private AppDatabase database;
    private Button btnTambah, btnListResi;
    private int id=0, berat2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        //Title action bar
        getSupportActionBar().setTitle(Html.fromHtml("<font color='#111111'>Tambah</font>"));

        //action bar color
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        //arrow action bar
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_baseline_arrow_back_ios_new_24);
        upArrow.setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);

        nmpenerima = findViewById(R.id.et_nmpenerima);
        almtpenerima = findViewById(R.id.et_almtpenerima);
        tlppenerima = findViewById(R.id.et_tlppenerima);
        nmpengirim = findViewById(R.id.et_nmpengirim);
        tlppengirim = findViewById(R.id.et_tlppengirim);
        kab_asal= findViewById(R.id.et_kabpengirim);
        kab_tujuan = findViewById(R.id.et_kabpenerima);
        barang = findViewById(R.id.et_barang);
        berat = findViewById(R.id.et_berat);
        berat2 = Integer.parseInt(berat.getText().toString());

        kab_asal.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchCityActivity.class);
                intent.putExtra("requestCode", REQUEST_SOURCE);
                startActivityForResult(intent, REQUEST_SOURCE);
            }
        });

        kab_tujuan.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SearchCityActivity.class);
                intent.putExtra("requestCode", REQUEST_DESTINATION);
                startActivityForResult(intent, REQUEST_DESTINATION);
            }
        });
    }

    private void insertResi(final Resi resi){
        new AsyncTask<Void, Void, Long>() {
            @Override
            protected Long doInBackground(Void... voids) {
                //Menjalankan proses insert data
                long status = database.resiDAO().insertResi(resi);
                return status;
            }

            @Override
            protected void onPostExecute(Long status) {
                //Menandakan bahwa data berhasil disimpan
                Toast.makeText(InsertActivity.this, "Resi berhasil ditambahkan", Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_tambah :
                if (nmpenerima.getText().toString().isEmpty()){
                    Toast.makeText(InsertActivity.this,"Nama Penerima tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else if (almtpenerima.getText().toString().isEmpty()) {
                    Toast.makeText(InsertActivity.this,"Alamat Penerima tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else if (tlppenerima.getText().toString().isEmpty()){
                    Toast.makeText(InsertActivity.this,"Nomor telepon Penerima tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else if (kab_asal.getText().toString().isEmpty()){
                    Toast.makeText(InsertActivity.this,"Kabupaten Asal tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else if (kab_tujuan.getText().toString().isEmpty()){
                    Toast.makeText(InsertActivity.this,"Kabupaten Tujuan tidak boleh kosong!", Toast.LENGTH_SHORT).show();
                } else{
                    Resi dataResi = new Resi();
                    //memasukkan data input ke dalam database
                    dataResi.setId(id);
                    dataResi.setNm_penerima(nmpenerima.getText().toString());
                    dataResi.setAlmt_penerima(almtpenerima.getText().toString());
                    dataResi.setTlp_penerima(tlppenerima.getText().toString());
                    dataResi.setNm_pengirim(nmpengirim.getText().toString());
                    dataResi.setTlp_pengirim(tlppengirim.getText().toString());
                    dataResi.setKab_asal(kab_asal.getText().toString());
                    dataResi.setKab_tujuan(kab_tujuan.getText().toString());
                    dataResi.setBarang(barang.getText().toString());
                    dataResi.setBerat(berat2);
                    insertResi(dataResi);


                    //Reset edit text
                    nmpenerima.setText("");
                    almtpenerima.setText("");
                    tlppenerima.setText("");
                    nmpengirim.setText("");
                    tlppengirim.setText("");
                    kab_asal.setText("");
                    kab_tujuan.setText("");
                    barang.setText("");
                    berat.setText("");
                }
                break;

            case R.id.btn_lihat :
                startActivity(new Intent(InsertActivity.this, ResiFragment.class));
                break;
        }
    }
}
