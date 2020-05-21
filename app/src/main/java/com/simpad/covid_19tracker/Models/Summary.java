
package com.simpad.covid_19tracker.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Summary implements Parcelable
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
    public final static Creator<Summary> CREATOR = new Creator<Summary>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Summary createFromParcel(Parcel in) {
            return new Summary(in);
        }

        public Summary[] newArray(int size) {
            return (new Summary[size]);
        }

    }
    ;

    protected Summary(Parcel in) {
        this.total = ((long) in.readValue((long.class.getClassLoader())));
        this.confirmedCasesIndian = ((long) in.readValue((long.class.getClassLoader())));
        this.confirmedCasesForeign = ((long) in.readValue((long.class.getClassLoader())));
        this.discharged = ((long) in.readValue((long.class.getClassLoader())));
        this.deaths = ((long) in.readValue((long.class.getClassLoader())));
        this.confirmedButLocationUnidentified = ((long) in.readValue((long.class.getClassLoader())));
    }

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



    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(total);
        dest.writeValue(confirmedCasesIndian);
        dest.writeValue(confirmedCasesForeign);
        dest.writeValue(discharged);
        dest.writeValue(deaths);
        dest.writeValue(confirmedButLocationUnidentified);
    }

    public int describeContents() {
        return  0;
    }

}
