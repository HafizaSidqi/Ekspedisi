package com.expedition.ekspedisi.ui.riwayat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.expedition.ekspedisi.R;

public class RiwayatFragment extends Fragment {
    private int time=400;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent splash=new Intent(RiwayatFragment.this.getActivity(), ReadActivity.class);
                startActivity(splash);
                //finish();

            }
        },time);
    }

    public RiwayatFragment() {
        //Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resi, container, false);
    }



}
