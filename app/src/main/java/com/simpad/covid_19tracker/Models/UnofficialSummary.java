
package com.simpad.covid_19tracker.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class UnofficialSummary implements Parcelable
{

    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("total")
    @Expose
    private long total;
    @SerializedName("recovered")
    @Expose
    private long recovered;
    @SerializedName("deaths")
    @Expose
    private long deaths;
    @SerializedName("active")
    @Expose
    private long active;
    public final static Creator<UnofficialSummary> CREATOR = new Creator<UnofficialSummary>() {


        @SuppressWarnings({
            "unchecked"
        })
        public UnofficialSummary createFromParcel(Parcel in) {
            return new UnofficialSummary(in);
        }

        public UnofficialSummary[] newArray(int size) {
            return (new UnofficialSummary[size]);
        }

    }
    ;

    protected UnofficialSummary(Parcel in) {
        this.source = ((String) in.readValue((String.class.getClassLoader())));
        this.total = ((long) in.readValue((long.class.getClassLoader())));
        this.recovered = ((long) in.readValue((long.class.getClassLoader())));
        this.deaths = ((long) in.readValue((long.class.getClassLoader())));
        this.active = ((long) in.readValue((long.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public UnofficialSummary() {
    }

    /**
     * 
     * @param total
     * @param recovered
     * @param active
     * @param source
     * @param deaths
     */
    public UnofficialSummary(String source, long total, long recovered, long deaths, long active) {
        super();
        this.source = source;
        this.total = total;
        this.recovered = recovered;
        this.deaths = deaths;
        this.active = active;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getRecovered() {
        return recovered;
    }

    public void setRecovered(long recovered) {
        this.recovered = recovered;
    }

    public long getDeaths() {
        return deaths;
    }

    public void setDeaths(long deaths) {
        this.deaths = deaths;
    }

    public long getActive() {
        return active;
    }

    public void setActive(long active) {
        this.active = active;
    }



    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(source);
        dest.writeValue(total);
        dest.writeValue(recovered);
        dest.writeValue(deaths);
        dest.writeValue(active);
    }

    public int describeContents() {
        return  0;
    }

}
