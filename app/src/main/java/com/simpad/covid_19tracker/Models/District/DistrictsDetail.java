
package com.simpad.covid_19tracker.Models.District;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DistrictsDetail implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("active")
    @Expose
    private long active;
    @SerializedName("confirmed")
    @Expose
    private long confirmed;
    @SerializedName("recovered")
    @Expose
    private long recovered;
    @SerializedName("deaths")
    @Expose
    private long deaths;
    @SerializedName("cChanges")
    @Expose
    private long cChanges;
    @SerializedName("rChanges")
    @Expose
    private long rChanges;
    @SerializedName("dChanges")
    @Expose
    private long dChanges;
    @SerializedName("districtData")
    @Expose
    private List<DistrictDatum> districtData = null;
    @SerializedName("cchanges")
    @Expose
    private long cchanges;
    @SerializedName("rchanges")
    @Expose
    private long rchanges;
    @SerializedName("dchanges")
    @Expose
    private long dchanges;
    public final static Parcelable.Creator<DistrictsDetail> CREATOR = new Creator<DistrictsDetail>() {


        @SuppressWarnings({
                "unchecked"
        })
        public DistrictsDetail createFromParcel(Parcel in) {
            return new DistrictsDetail(in);
        }

        public DistrictsDetail[] newArray(int size) {
            return (new DistrictsDetail[size]);
        }

    }
            ;

    protected DistrictsDetail(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.state = ((String) in.readValue((String.class.getClassLoader())));
        this.active = ((long) in.readValue((long.class.getClassLoader())));
        this.confirmed = ((long) in.readValue((long.class.getClassLoader())));
        this.recovered = ((long) in.readValue((long.class.getClassLoader())));
        this.deaths = ((long) in.readValue((long.class.getClassLoader())));
        this.cChanges = ((long) in.readValue((long.class.getClassLoader())));
        this.rChanges = ((long) in.readValue((long.class.getClassLoader())));
        this.dChanges = ((long) in.readValue((long.class.getClassLoader())));
        in.readList(this.districtData, (com.simpad.covid_19tracker.Models.District.DistrictDatum.class.getClassLoader()));
        this.cchanges = ((long) in.readValue((long.class.getClassLoader())));
        this.rchanges = ((long) in.readValue((long.class.getClassLoader())));
        this.dchanges = ((long) in.readValue((long.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public DistrictsDetail() {
    }

    /**
     *
     * @param rchanges
     * @param districtData
     * @param dChanges
     * @param active
     * @param confirmed
     * @param recovered
     * @param cChanges
     * @param rChanges
     * @param id
     * @param state
     * @param deaths
     * @param cchanges
     * @param dchanges
     */
    public DistrictsDetail(String id, String state, long active, long confirmed, long recovered, long deaths, long cChanges, long rChanges, long dChanges, List<DistrictDatum> districtData, long cchanges, long rchanges, long dchanges) {
        super();
        this.id = id;
        this.state = state;
        this.active = active;
        this.confirmed = confirmed;
        this.recovered = recovered;
        this.deaths = deaths;
        this.cChanges = cChanges;
        this.rChanges = rChanges;
        this.dChanges = dChanges;
        this.districtData = districtData;
        this.cchanges = cchanges;
        this.rchanges = rchanges;
        this.dchanges = dchanges;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DistrictsDetail withId(String id) {
        this.id = id;
        return this;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public DistrictsDetail withState(String state) {
        this.state = state;
        return this;
    }

    public long getActive() {
        return active;
    }

    public void setActive(long active) {
        this.active = active;
    }

    public DistrictsDetail withActive(long active) {
        this.active = active;
        return this;
    }

    public long getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(long confirmed) {
        this.confirmed = confirmed;
    }

    public DistrictsDetail withConfirmed(long confirmed) {
        this.confirmed = confirmed;
        return this;
    }

    public long getRecovered() {
        return recovered;
    }

    public void setRecovered(long recovered) {
        this.recovered = recovered;
    }

    public DistrictsDetail withRecovered(long recovered) {
        this.recovered = recovered;
        return this;
    }

    public long getDeaths() {
        return deaths;
    }

    public void setDeaths(long deaths) {
        this.deaths = deaths;
    }

    public DistrictsDetail withDeaths(long deaths) {
        this.deaths = deaths;
        return this;
    }

    public long getCChanges() {
        return cChanges;
    }

    public void setCChanges(long cChanges) {
        this.cChanges = cChanges;
    }

    public DistrictsDetail withCChanges(long cChanges) {
        this.cChanges = cChanges;
        return this;
    }

    public long getRChanges() {
        return rChanges;
    }

    public void setRChanges(long rChanges) {
        this.rChanges = rChanges;
    }

    public DistrictsDetail withRChanges(long rChanges) {
        this.rChanges = rChanges;
        return this;
    }

    public long getDChanges() {
        return dChanges;
    }

    public void setDChanges(long dChanges) {
        this.dChanges = dChanges;
    }

    public DistrictsDetail withDChanges(long dChanges) {
        this.dChanges = dChanges;
        return this;
    }

    public List<DistrictDatum> getDistrictData() {
        return districtData;
    }

    public void setDistrictData(List<DistrictDatum> districtData) {
        this.districtData = districtData;
    }

    public DistrictsDetail withDistrictData(List<DistrictDatum> districtData) {
        this.districtData = districtData;
        return this;
    }

    public long getCchanges() {
        return cchanges;
    }

    public void setCchanges(long cchanges) {
        this.cchanges = cchanges;
    }

    public DistrictsDetail withCchanges(long cchanges) {
        this.cchanges = cchanges;
        return this;
    }

    public long getRchanges() {
        return rchanges;
    }

    public void setRchanges(long rchanges) {
        this.rchanges = rchanges;
    }

    public DistrictsDetail withRchanges(long rchanges) {
        this.rchanges = rchanges;
        return this;
    }

    public long getDchanges() {
        return dchanges;
    }

    public void setDchanges(long dchanges) {
        this.dchanges = dchanges;
    }

    public DistrictsDetail withDchanges(long dchanges) {
        this.dchanges = dchanges;
        return this;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(state);
        dest.writeValue(active);
        dest.writeValue(confirmed);
        dest.writeValue(recovered);
        dest.writeValue(deaths);
        dest.writeValue(cChanges);
        dest.writeValue(rChanges);
        dest.writeValue(dChanges);
        dest.writeList(districtData);
        dest.writeValue(cchanges);
        dest.writeValue(rchanges);
        dest.writeValue(dchanges);
    }

    public int describeContents() {
        return  0;
    }

}