
package com.simpad.covid_19tracker.Models.ContactDetails;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data implements Serializable, Parcelable
{

    @SerializedName("contacts")
    @Expose
    private Contacts_ contacts;
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
    private final static long serialVersionUID = 6736680344945699617L;

    protected Data(Parcel in) {
        this.contacts = ((Contacts_) in.readValue((Contacts_.class.getClassLoader())));
    }

    public Data() {
    }

    public Contacts_ getContacts() {
        return contacts;
    }

    public void setContacts(Contacts_ contacts) {
        this.contacts = contacts;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(contacts);
    }

    public int describeContents() {
        return  0;
    }

}
