
package com.simpad.covid_19tracker.Models.History;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Regional implements Serializable
{

    @SerializedName("loc")
    @Expose
    private String loc;
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
    @SerializedName("totalConfirmed")
    @Expose
    private long totalConfirmed;
    private final static long serialVersionUID = 4582668087285266017L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Regional() {
    }

    /**
     * 
     * @param loc
     * @param confirmedCasesForeign
     * @param discharged
     * @param confirmedCasesIndian
     * @param deaths
     * @param totalConfirmed
     */
    public Regional(String loc, long confirmedCasesIndian, long confirmedCasesForeign, long discharged, long deaths, long totalConfirmed) {
        super();
        this.loc = loc;
        this.confirmedCasesIndian = confirmedCasesIndian;
        this.confirmedCasesForeign = confirmedCasesForeign;
        this.discharged = discharged;
        this.deaths = deaths;
        this.totalConfirmed = totalConfirmed;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
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

    public long getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(long totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }

}
