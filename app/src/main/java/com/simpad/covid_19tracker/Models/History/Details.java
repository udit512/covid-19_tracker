
package com.simpad.covid_19tracker.Models.History;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Details implements Serializable
{

    @SerializedName("success")
    @Expose
    private boolean success;
    @SerializedName("data")
    @Expose
    private List<Datum> data;
    private final static long serialVersionUID = -5209709659677025864L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Details() {
    }

    /**
     * 
     * @param data
     * @param success
     */
    public Details(boolean success, List<Datum> data) {
        super();
        this.success = success;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

}
