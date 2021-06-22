package com.expedition.ekspedisi.network;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.expedition.ekspedisi.data.riwayat.Riwayat;

@Database(entities = {Riwayat.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    //Akses database menggunakan method abstract
    public abstract RiwayatDAO riwayatDAO();

    private static AppDatabase appDatabase;
    public static AppDatabase iniDb(Context context){
        if(appDatabase == null)
            appDatabase = Room.databaseBuilder(context, AppDatabase.class, "dbRiwayat").allowMainThreadQueries().build();
        return appDatabase; }

}
