package com.simpad.covid_19tracker.Models.SamplesTested;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("totalSamplesTested")
    @Expose
    private long totalSamplesTested;
    @SerializedName("totalIndividualsTested")
    @Expose
    private Object totalIndividualsTested;
    @SerializedName("totalPositiveCases")
    @Expose
    private Object totalPositiveCases;
    @SerializedName("source")
    @Expose
    private String source;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public long getTotalSamplesTested() {
        return totalSamplesTested;
    }

    public void setTotalSamplesTested(long totalSamplesTested) {
        this.totalSamplesTested = totalSamplesTested;
    }

    public Object getTotalIndividualsTested() {
        return totalIndividualsTested;
    }

    public void setTotalIndividualsTested(Object totalIndividualsTested) {
        this.totalIndividualsTested = totalIndividualsTested;
    }

    public Object getTotalPositiveCases() {
        return totalPositiveCases;
    }

    public void setTotalPositiveCases(Object totalPositiveCases) {
        this.totalPositiveCases = totalPositiveCases;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}