package com.expedition.ekspedisi.ui;

import android.os.Bundle;
import android.renderscript.Element;

import java.util.List;

public interface MainContract {
    interface Presenter{
        void getJNE();
        void getTIKI();
        void getPOS();
        void setupENV(String origin, String destination, int weight);
    }

    interface View{

        void onViewCreate(android.view.View view, Bundle savedInstanceState);

        void onLoadingCost(boolean loadng, int progress);
        void onResultCost(List<Element.DataType> data, List<String> courier);
        void onErrorCost();

        void showMessage(String msg);
        String getOrigin();
        String getDestination();
    }
}
