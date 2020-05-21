
package com.simpad.covid_19tracker.Models.ContactDetails;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Regional implements Serializable, Parcelable
{

    @SerializedName("loc")
    @Expose
    private String loc;
    @SerializedName("number")
    @Expose
    private String number;
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
    private final static long serialVersionUID = 377344146884141396L;

    protected Regional(Parcel in) {
        this.loc = ((String) in.readValue((String.class.getClassLoader())));
        this.number = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Regional() {
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(loc);
        dest.writeValue(number);
    }

    public int describeContents() {
        return  0;
    }

}
