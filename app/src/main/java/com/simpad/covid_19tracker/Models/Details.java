
package com.simpad.covid_19tracker.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Details implements Parcelable
{

    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("lastRefreshed")
    @Expose
    private String lastRefreshed;
    @SerializedName("lastOriginUpdate")
    @Expose
    private String lastOriginUpdate;
    public final static Creator<Details> CREATOR = new Creator<Details>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Details createFromParcel(Parcel in) {
            return new Details(in);
        }

        public Details[] newArray(int size) {
            return (new Details[size]);
        }

    }
    ;

    protected Details(Parcel in) {
        this.success = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
        this.lastRefreshed = ((String) in.readValue((String.class.getClassLoader())));
        this.lastOriginUpdate = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public Details() {
    }

    /**
     * 
     * @param lastRefreshed
     * @param data
     * @param success
     * @param lastOriginUpdate
     */
    public Details(boolean success, Data data, String lastRefreshed, String lastOriginUpdate) {
        super();
        this.success = success;
        this.data = data;
        this.lastRefreshed = lastRefreshed;
        this.lastOriginUpdate = lastOriginUpdate;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getLastRefreshed() {
        return lastRefreshed;
    }

    public void setLastRefreshed(String lastRefreshed) {
        this.lastRefreshed = lastRefreshed;
    }

    public String getLastOriginUpdate() {
        return lastOriginUpdate;
    }

    public void setLastOriginUpdate(String lastOriginUpdate) {
        this.lastOriginUpdate = lastOriginUpdate;
    }



    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(success);
        dest.writeValue(data);
        dest.writeValue(lastRefreshed);
        dest.writeValue(lastOriginUpdate);
    }

    public int describeContents() {
        return  0;
    }

}
