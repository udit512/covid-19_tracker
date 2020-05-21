
package com.simpad.covid_19tracker.Models.ContactDetails;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contacts implements Serializable, Parcelable
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
    public final static Creator<Contacts> CREATOR = new Creator<Contacts>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Contacts createFromParcel(Parcel in) {
            return new Contacts(in);
        }

        public Contacts[] newArray(int size) {
            return (new Contacts[size]);
        }

    }
    ;
    private final static long serialVersionUID = 7346044483358607477L;

    protected Contacts(Parcel in) {
        this.success = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.data = ((Data) in.readValue((Data.class.getClassLoader())));
        this.lastRefreshed = ((String) in.readValue((String.class.getClassLoader())));
        this.lastOriginUpdate = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Contacts() {
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
