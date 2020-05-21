
package com.simpad.covid_19tracker.Models.History;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum implements Serializable
{

    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("summary")
    @Expose
    private Summary summary;
    @SerializedName("regional")
    @Expose
    private List<Regional> regional;
    private final static long serialVersionUID = 6518697960844330190L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Datum() {
    }

    /**
     * 
     * @param summary
     * @param regional
     * @param day
     */
    public Datum(String day, Summary summary, List<Regional> regional) {
        super();
        this.day = day;
        this.summary = summary;
        this.regional = regional;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public List<Regional> getRegional() {
        return regional;
    }

    public void setRegional(List<Regional> regional) {
        this.regional = regional;
    }

}
