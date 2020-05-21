
package com.simpad.covid_19tracker.Models.ContactDetails;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contacts_ implements Serializable, Parcelable
{

    @SerializedName("primary")
    @Expose
    private Primary primary;
    @SerializedName("regional")
    @Expose
    private List<Regional> regional = null;
    public final static Creator<Contacts_> CREATOR = new Creator<Contacts_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Contacts_ createFromParcel(Parcel in) {
            return new Contacts_(in);
        }

        public Contacts_[] newArray(int size) {
            return (new Contacts_[size]);
        }

    }
    ;
    private final static long serialVersionUID = 4412601484810442017L;

    protected Contacts_(Parcel in) {
        this.primary = ((Primary) in.readValue((Primary.class.getClassLoader())));
        in.readList(this.regional, (com.simpad.covid_19tracker.Models.ContactDetails.Regional.class.getClassLoader()));
    }

    public Contacts_() {
    }

    public Primary getPrimary() {
        return primary;
    }

    public void setPrimary(Primary primary) {
        this.primary = primary;
    }

    public List<Regional> getRegional() {
        return regional;
    }

    public void setRegional(List<Regional> regional) {
        this.regional = regional;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(primary);
        dest.writeList(regional);
    }

    public int describeContents() {
        return  0;
    }

}
