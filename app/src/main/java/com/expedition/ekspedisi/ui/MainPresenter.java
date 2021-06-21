package com.expedition.ekspedisi.ui;

import com.expedition.ekspedisi.data.cost.DataType;
import com.expedition.ekspedisi.network.Api;
import com.expedition.ekspedisi.network.ApiEndpoint;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter implements MainContract.Presenter{

    MainContract.View view;
    ApiEndpoint endpoint;

    String origin = "";
    String destination = "";
    int weight = 0;

    List<DataType> output = new ArrayList<>();
    List<String> courier = new ArrayList<>();

    public MainPresenter(MainContract.View view) {
        this.view = view;
        endpoint = Api.getUrl().create(ApiEndpoint.class);
    }

    @Override
    public void getJNE() {

    }

    @Override
    public void getTIKI() {

    }

    @Override
    public void getPOS() {

    }

    @Override
    public void setupENV(String origin, String destination, int weight) {

    }
}
