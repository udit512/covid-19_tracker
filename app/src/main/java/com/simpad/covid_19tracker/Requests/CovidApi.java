package com.simpad.covid_19tracker.Requests;

import com.simpad.covid_19tracker.Models.ContactDetails.Contacts;
import com.simpad.covid_19tracker.Models.Data;
import com.simpad.covid_19tracker.Models.Details;
import com.simpad.covid_19tracker.Models.District.DistrictsDetail;
import com.simpad.covid_19tracker.Models.Hospitals.Hospital;
import com.simpad.covid_19tracker.Models.SamplesTested.Sample;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CovidApi {

    //Get India Details
    @GET("stats/latest")
    Call<Details> getDetails();

    @GET("stats/testing/latest")
    Call<Sample> getSamples();

    @GET("contacts")
    Call<Contacts> getContacts();

    @GET("hospitals/medical-colleges")
    Call<Hospital> getHospitals();

    @GET("stats/history")
    Call<com.simpad.covid_19tracker.Models.History.Details> getDetailedHistory();

    @GET("https://api.covidindiatracker.com/state_data.json")
    Call<List<DistrictsDetail>> getDistrict();

}
