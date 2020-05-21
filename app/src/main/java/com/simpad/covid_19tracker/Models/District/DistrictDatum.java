
package com.simpad.covid_19tracker.Models.District;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictDatum implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("state")
    @Expose
    private Object state;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("confirmed")
    @Expose
    private long confirmed;
    @SerializedName("recovered")
    @Expose
    private Object recovered;
    @SerializedName("deaths")
    @Expose
    private Object deaths;
    @SerializedName("oldConfirmed")
    @Expose
    private long oldConfirmed;
    @SerializedName("oldRecovered")
    @Expose
    private Object oldRecovered;
    @SerializedName("oldDeaths")
    @Expose
    private Object oldDeaths;
    @SerializedName("zone")
    @Expose
    private String zone;
    public final static Creator<DistrictDatum> CREATOR = new Creator<DistrictDatum>() {


        @SuppressWarnings({
            "unchecked"
        })
        public DistrictDatum createFromParcel(Parcel in) {
            return new DistrictDatum(in);
        }

        public DistrictDatum[] newArray(int size) {
            return (new DistrictDatum[size]);
        }

    }
    ;

    protected DistrictDatum(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.state = ((Object) in.readValue((Object.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.confirmed = ((long) in.readValue((long.class.getClassLoader())));
        this.recovered = ((Object) in.readValue((Object.class.getClassLoader())));
        this.deaths = ((Object) in.readValue((Object.class.getClassLoader())));
        this.oldConfirmed = ((long) in.readValue((long.class.getClassLoader())));
        this.oldRecovered = ((Object) in.readValue((Object.class.getClassLoader())));
        this.oldDeaths = ((Object) in.readValue((Object.class.getClassLoader())));
        this.zone = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public DistrictDatum() {
    }

    /**
     * 
     * @param recovered
     * @param zone
     * @param oldDeaths
     * @param name
     * @param oldRecovered
     * @param id
     * @param state
     * @param confirmed
     * @param deaths
     * @param oldConfirmed
     */
    public DistrictDatum(String id, Object state, String name, long confirmed, Object recovered, Object deaths, long oldConfirmed, Object oldRecovered, Object oldDeaths, String zone) {
        super();
        this.id = id;
        this.state = state;
        this.name = name;
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.deaths = deaths;
        this.oldConfirmed = oldConfirmed;
        this.oldRecovered = oldRecovered;
        this.oldDeaths = oldDeaths;
        this.zone = zone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DistrictDatum withId(String id) {
        this.id = id;
        return this;
    }

    public Object getState() {
        return state;
    }

    public void setState(Object state) {
        this.state = state;
    }

    public DistrictDatum withState(Object state) {
        this.state = state;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DistrictDatum withName(String name) {
        this.name = name;
        return this;
    }

    public long getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(long confirmed) {
        this.confirmed = confirmed;
    }

    public DistrictDatum withConfirmed(long confirmed) {
        this.confirmed = confirmed;
        return this;
    }

    public Object getRecovered() {
        return recovered;
    }

    public void setRecovered(Object recovered) {
        this.recovered = recovered;
    }

    public DistrictDatum withRecovered(Object recovered) {
        this.recovered = recovered;
        return this;
    }

    public Object getDeaths() {
        return deaths;
    }

    public void setDeaths(Object deaths) {
        this.deaths = deaths;
    }

    public DistrictDatum withDeaths(Object deaths) {
        this.deaths = deaths;
        return this;
    }

    public long getOldConfirmed() {
        return oldConfirmed;
    }

    public void setOldConfirmed(long oldConfirmed) {
        this.oldConfirmed = oldConfirmed;
    }

    public DistrictDatum withOldConfirmed(long oldConfirmed) {
        this.oldConfirmed = oldConfirmed;
        return this;
    }

    public Object getOldRecovered() {
        return oldRecovered;
    }

    public void setOldRecovered(Object oldRecovered) {
        this.oldRecovered = oldRecovered;
    }

    public DistrictDatum withOldRecovered(Object oldRecovered) {
        this.oldRecovered = oldRecovered;
        return this;
    }

    public Object getOldDeaths() {
        return oldDeaths;
    }

    public void setOldDeaths(Object oldDeaths) {
        this.oldDeaths = oldDeaths;
    }

    public DistrictDatum withOldDeaths(Object oldDeaths) {
        this.oldDeaths = oldDeaths;
        return this;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }

    public DistrictDatum withZone(String zone) {
        this.zone = zone;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(state);
        dest.writeValue(name);
        dest.writeValue(confirmed);
        dest.writeValue(recovered);
        dest.writeValue(deaths);
        dest.writeValue(oldConfirmed);
        dest.writeValue(oldRecovered);
        dest.writeValue(oldDeaths);
        dest.writeValue(zone);
    }

    public int describeContents() {
        return  0;
    }

}
