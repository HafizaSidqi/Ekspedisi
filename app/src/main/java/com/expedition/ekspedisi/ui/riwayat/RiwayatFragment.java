package com.expedition.ekspedisi.ui.resi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.expedition.ekspedisi.R;
import com.expedition.ekspedisi.ui.MainActivity;

public class ResiFragment extends Fragment {
    private int time=4000;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent splash=new Intent(ResiFragment.this.getActivity(), ReadActivity.class);
                startActivity(splash);
                //finish();

            }
        },time);
    }

    public ResiFragment() {
        //Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resi, container, false);
    }



}
