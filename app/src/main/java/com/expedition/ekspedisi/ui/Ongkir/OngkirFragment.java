package com.expedition.ekspedisi.ui.Ongkir;

import android.os.Bundle;
import android.renderscript.Element;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.expedition.ekspedisi.data.cost.DataType;
import com.expedition.ekspedisi.ui.MainContract;
import com.expedition.ekspedisi.ui.MainPresenter;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class OngkirFragment extends Fragment implements MainContract.View{

    private static final int REQUEST_SOURCE = 1;
    private static final int REQUEST_DESTINATION = 2;

    private String source_id = "";
    private String destination_id = "";

    private MainPresenter presenter;
    private OngkirAdapter adapter;

    private List<DataType> data = new ArrayList<>();
    private List<String> courier = new ArrayList<>();

    TextInputEditText inputKotaAsal, inputKotaTujuan;
    Button btnSubmit;
    LinearLayout llMain;
    RecyclerView rvMain;
    ProgressBar progressBar;

    @Override
    public void onViewCreate(View view, Bundle savedInstanceState) {

    }

    @Override
    public void onLoadingCost(boolean loadng, int progress) {

    }

    @Override
    public void onResultCost(List<Element.DataType> data, List<String> courier) {

    }

    @Override
    public void onErrorCost() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public String getOrigin() {
        return null;
    }

    @Override
    public String getDestination() {
        return null;
    }
}
