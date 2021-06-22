package com.expedition.ekspedisi.data.riwayat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tRiwayat")
public class Riwayat implements Serializable {

    //kolom id sebagai primary key
    @NonNull
    @ColumnInfo(name = "id_riwayatu")
    @PrimaryKey(autoGenerate = true)
    private int id=0;
    //kolom judul lagu
    @ColumnInfo(name = "kab_asal", defaultValue = "null")
    private String kab_asal;
    //kolom judul lagu
    @ColumnInfo(name = "kab_tujuan", defaultValue = "null")
    private String kab_tujuan;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKab_asal() {
        return kab_asal;
    }

    public void setKab_asal(String kab_asal) {
        this.kab_asal = kab_asal;
    }

    public String getKab_tujuan() {
        return kab_tujuan;
    }

    public void setKab_tujuan(String kab_tujuan) {
        this.kab_tujuan = kab_tujuan;
    }
}
