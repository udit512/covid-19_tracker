
package com.simpad.covid_19tracker.Models.Hospitals;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data implements Serializable, Parcelable
{

    @SerializedName("medicalColleges")
    @Expose
    private List<MedicalCollege> medicalColleges = null;
    @SerializedName("sources")
    @Expose
    private List<String> sources = null;
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
    private final static long serialVersionUID = 45744804942414294L;

    protected Data(Parcel in) {
        in.readList(this.medicalColleges, (com.simpad.covid_19tracker.Models.Hospitals.MedicalCollege.class.getClassLoader()));
        in.readList(this.sources, (String.class.getClassLoader()));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Data() {
    }

    /**
     * 
     * @param sources
     * @param medicalColleges
     */
    public Data(List<MedicalCollege> medicalColleges, List<String> sources) {
        super();
        this.medicalColleges = medicalColleges;
        this.sources = sources;
    }

    public List<MedicalCollege> getMedicalColleges() {
        return medicalColleges;
    }

    public void setMedicalColleges(List<MedicalCollege> medicalColleges) {
        this.medicalColleges = medicalColleges;
    }

    public List<String> getSources() {
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(medicalColleges);
        dest.writeList(sources);
    }

    public int describeContents() {
        return  0;
    }

}
