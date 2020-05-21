
package com.simpad.covid_19tracker.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Regional implements Parcelable, Serializable
{

    @SerializedName("loc")
    @Expose
    private String loc;
    @SerializedName("confirmedCasesIndian")
    @Expose
    private long confirmedCasesIndian;
    @SerializedName("discharged")
    @Expose
    private long discharged;
    @SerializedName("deaths")
    @Expose
    private long deaths;
    @SerializedName("confirmedCasesForeign")
    @Expose
    private long confirmedCasesForeign;
    @SerializedName("totalConfirmed")
    @Expose
    private long totalConfirmed;
    public final static Creator<Regional> CREATOR = new Creator<Regional>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Regional createFromParcel(Parcel in) {
            return new Regional(in);
        }

        public Regional[] newArray(int size) {
            return (new Regional[size]);
        }

    }
    ;

    protected Regional(Parcel in) {
        this.loc = ((String) in.readValue((String.class.getClassLoader())));
        this.confirmedCasesIndian = ((long) in.readValue((long.class.getClassLoader())));
        this.discharged = ((long) in.readValue((long.class.getClassLoader())));
        this.deaths = ((long) in.readValue((long.class.getClassLoader())));
        this.confirmedCasesForeign = ((long) in.readValue((long.class.getClassLoader())));
        this.totalConfirmed = ((long) in.readValue((long.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Regional() {
    }

    /**
     * 
     * @param loc
     * @param discharged
     * @param confirmedCasesForeign
     * @param confirmedCasesIndian
     * @param deaths
     * @param totalConfirmed
     */
    public Regional(String loc, long confirmedCasesIndian, long discharged, long deaths, long confirmedCasesForeign, long totalConfirmed) {
        super();
        this.loc = loc;
        this.confirmedCasesIndian = confirmedCasesIndian;
        this.discharged = discharged;
        this.deaths = deaths;
        this.confirmedCasesForeign = confirmedCasesForeign;
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

    public long getConfirmedCasesForeign() {
        return confirmedCasesForeign;
    }

    public void setConfirmedCasesForeign(long confirmedCasesForeign) {
        this.confirmedCasesForeign = confirmedCasesForeign;
    }

    public long getTotalConfirmed() {
        return totalConfirmed;
    }

    public void setTotalConfirmed(long totalConfirmed) {
        this.totalConfirmed = totalConfirmed;
    }



    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(loc);
        dest.writeValue(confirmedCasesIndian);
        dest.writeValue(discharged);
        dest.writeValue(deaths);
        dest.writeValue(confirmedCasesForeign);
        dest.writeValue(totalConfirmed);
    }

    public int describeContents() {
        return  0;
    }

}
