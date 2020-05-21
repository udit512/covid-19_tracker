
package com.simpad.covid_19tracker.Models.Hospitals;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MedicalCollege implements Serializable, Parcelable
{

    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("ownership")
    @Expose
    private String ownership;
    @SerializedName("admissionCapacity")
    @Expose
    private long admissionCapacity;
    @SerializedName("hospitalBeds")
    @Expose
    private long hospitalBeds;
    public final static Creator<MedicalCollege> CREATOR = new Creator<MedicalCollege>() {


        @SuppressWarnings({
            "unchecked"
        })
        public MedicalCollege createFromParcel(Parcel in) {
            return new MedicalCollege(in);
        }

        public MedicalCollege[] newArray(int size) {
            return (new MedicalCollege[size]);
        }

    }
    ;
    private final static long serialVersionUID = -6687928113741366942L;

    protected MedicalCollege(Parcel in) {
        this.state = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.city = ((String) in.readValue((String.class.getClassLoader())));
        this.ownership = ((String) in.readValue((String.class.getClassLoader())));
        this.admissionCapacity = ((long) in.readValue((long.class.getClassLoader())));
        this.hospitalBeds = ((long) in.readValue((long.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public MedicalCollege() {
    }

    /**
     * 
     * @param admissionCapacity
     * @param ownership
     * @param hospitalBeds
     * @param city
     * @param name
     * @param state
     */
    public MedicalCollege(String state, String name, String city, String ownership, long admissionCapacity, long hospitalBeds) {
        super();
        this.state = state;
        this.name = name;
        this.city = city;
        this.ownership = ownership;
        this.admissionCapacity = admissionCapacity;
        this.hospitalBeds = hospitalBeds;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public long getAdmissionCapacity() {
        return admissionCapacity;
    }

    public void setAdmissionCapacity(long admissionCapacity) {
        this.admissionCapacity = admissionCapacity;
    }

    public long getHospitalBeds() {
        return hospitalBeds;
    }

    public void setHospitalBeds(long hospitalBeds) {
        this.hospitalBeds = hospitalBeds;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(state);
        dest.writeValue(name);
        dest.writeValue(city);
        dest.writeValue(ownership);
        dest.writeValue(admissionCapacity);
        dest.writeValue(hospitalBeds);
    }

    public int describeContents() {
        return  0;
    }

}
