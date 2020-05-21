
package com.simpad.covid_19tracker.Models;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Data implements Parcelable
{

    @SerializedName("summary")
    @Expose
    private Summary summary;
    @SerializedName("unofficial-summary")
    @Expose
    private List<UnofficialSummary> unofficialSummary;
    @SerializedName("regional")
    @Expose
    private List<Regional> regional;
    public final static Creator<Data> CREATOR = new Creator<Data>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Data createFromParcel(Parcel in) {
            return new Data(in);
        }

        public Data[] newArray(int size) {
            return (new Data[size]);
        }

    }
    ;

    protected Data(Parcel in) {
        this.summary = ((Summary) in.readValue((Summary.class.getClassLoader())));
        in.readList(this.unofficialSummary, (com.simpad.covid_19tracker.Models.UnofficialSummary.class.getClassLoader()));
        in.readList(this.regional, (com.simpad.covid_19tracker.Models.Regional.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Data() {
    }

    /**
     * 
     * @param summary
     * @param regional
     * @param unofficialSummary
     */
    public Data(Summary summary, List<UnofficialSummary> unofficialSummary, List<Regional> regional) {
        super();
        this.summary = summary;
        this.unofficialSummary = unofficialSummary;
        this.regional = regional;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public List<UnofficialSummary> getUnofficialSummary() {
        return unofficialSummary;
    }

    public void setUnofficialSummary(List<UnofficialSummary> unofficialSummary) {
        this.unofficialSummary = unofficialSummary;
    }

    public List<Regional> getRegional() {
        return regional;
    }

    public void setRegional(List<Regional> regional) {
        this.regional = regional;
    }



    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(summary);
        dest.writeList(unofficialSummary);
        dest.writeList(regional);
    }

    public int describeContents() {
        return  0;
    }

}
