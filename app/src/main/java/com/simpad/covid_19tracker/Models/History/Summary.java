
package com.simpad.covid_19tracker.Models.History;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Summary implements Serializable
{

    @SerializedName("total")
    @Expose
    private long total;
    @SerializedName("confirmedCasesIndian")
    @Expose
    private long confirmedCasesIndian;
    @SerializedName("confirmedCasesForeign")
    @Expose
    private long confirmedCasesForeign;
    @SerializedName("discharged")
    @Expose
    private long discharged;
    @SerializedName("deaths")
    @Expose
    private long deaths;
    @SerializedName("confirmedButLocationUnidentified")
    @Expose
    private long confirmedButLocationUnidentified;
    private final static long serialVersionUID = 4200632237310815121L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Summary() {
    }

    /**
     * 
     * @param total
     * @param confirmedButLocationUnidentified
     * @param confirmedCasesForeign
     * @param discharged
     * @param confirmedCasesIndian
     * @param deaths
     */
    public Summary(long total, long confirmedCasesIndian, long confirmedCasesForeign, long discharged, long deaths, long confirmedButLocationUnidentified) {
        super();
        this.total = total;
        this.confirmedCasesIndian = confirmedCasesIndian;
        this.confirmedCasesForeign = confirmedCasesForeign;
        this.discharged = discharged;
        this.deaths = deaths;
        this.confirmedButLocationUnidentified = confirmedButLocationUnidentified;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getConfirmedCasesIndian() {
        return confirmedCasesIndian;
    }

    public void setConfirmedCasesIndian(long confirmedCasesIndian) {
        this.confirmedCasesIndian = confirmedCasesIndian;
    }

    public long getConfirmedCasesForeign() {
        return confirmedCasesForeign;
    }

    public void setConfirmedCasesForeign(long confirmedCasesForeign) {
        this.confirmedCasesForeign = confirmedCasesForeign;
    }

    public long getDischarged() {
        return discharged;
    }

    public void setDischarged(long discharged) {
        this.discharged = discharged;
    }

    public long getDeaths() {
        return deaths;
    }

    public void setDeaths(long deaths) {
        this.deaths = deaths;
    }

    public long getConfirmedButLocationUnidentified() {
        return confirmedButLocationUnidentified;
    }

    public void setConfirmedButLocationUnidentified(long confirmedButLocationUnidentified) {
        this.confirmedButLocationUnidentified = confirmedButLocationUnidentified;
    }

}
