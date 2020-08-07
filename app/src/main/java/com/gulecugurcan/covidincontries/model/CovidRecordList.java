package com.gulecugurcan.covidincontries.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CovidRecordList {
    @SerializedName("result")
    public List<CovidModel> covids;
}
