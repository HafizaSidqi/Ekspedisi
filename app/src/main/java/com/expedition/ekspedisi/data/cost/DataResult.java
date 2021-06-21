package com.expedition.ekspedisi.data.cost;

import android.renderscript.Element;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class DataResult implements Serializable {
    @SerializedName("code")
    @Expose
    public String code;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("costs")
    @Expose
    public List<Element.DataType> costs = null;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Element.DataType> getCosts() {
        return costs;
    }

    public void setCosts(List<Element.DataType> costs) {
        this.costs = costs;
    }

}
