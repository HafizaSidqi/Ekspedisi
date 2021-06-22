package com.expedition.ekspedisi.network;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.expedition.ekspedisi.data.riwayat.Riwayat;

@Dao
public interface RiwayatDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public long insertRiwayat(Riwayat riwayat);

    @Query("SELECT * FROM tRiwayat")
    Riwayat[] readDataRiwayat();
}
