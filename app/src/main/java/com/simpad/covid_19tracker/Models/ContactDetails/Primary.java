
package com.simpad.covid_19tracker.Models.ContactDetails;

import java.io.Serializable;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Primary implements Serializable, Parcelable
{

    @SerializedName("number")
    @Expose
    private String number;
    @SerializedName("number-tollfree")
    @Expose
    private String numberTollfree;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("twitter")
    @Expose
    private String twitter;
    @SerializedName("facebook")
    @Expose
    private String facebook;
    @SerializedName("media")
    @Expose
    private List<String> media = null;
    public final static Creator<Primary> CREATOR = new Creator<Primary>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Primary createFromParcel(Parcel in) {
            return new Primary(in);
        }

        public Primary[] newArray(int size) {
            return (new Primary[size]);
        }

    }
    ;
    private final static long serialVersionUID = 996811834824544353L;

    protected Primary(Parcel in) {
        this.number = ((String) in.readValue((String.class.getClassLoader())));
        this.numberTollfree = ((String) in.readValue((String.class.getClassLoader())));
        this.email = ((String) in.readValue((String.class.getClassLoader())));
        this.twitter = ((String) in.readValue((String.class.getClassLoader())));
        this.facebook = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.media, (String.class.getClassLoader()));
    }

    public Primary() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumberTollfree() {
        return numberTollfree;
    }

    public void setNumberTollfree(String numberTollfree) {
        this.numberTollfree = numberTollfree;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public List<String> getMedia() {
        return media;
    }

    public void setMedia(List<String> media) {
        this.media = media;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(number);
        dest.writeValue(numberTollfree);
        dest.writeValue(email);
        dest.writeValue(twitter);
        dest.writeValue(facebook);
        dest.writeList(media);
    }

    public int describeContents() {
        return  0;
    }

}
