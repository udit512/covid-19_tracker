package com.simpad.covid_19tracker.Repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.simpad.covid_19tracker.Models.ContactDetails.Contacts;
import com.simpad.covid_19tracker.Models.Details;
import com.simpad.covid_19tracker.Models.District.DistrictsDetail;
import com.simpad.covid_19tracker.Models.Hospitals.Hospital;
import com.simpad.covid_19tracker.Models.SamplesTested.Sample;
import com.simpad.covid_19tracker.Requests.ContactsClientApi;
import com.simpad.covid_19tracker.Requests.DetailedHistoryClientApi;
import com.simpad.covid_19tracker.Requests.DetailsClientApi;
import com.simpad.covid_19tracker.Requests.DistrictClientApi;
import com.simpad.covid_19tracker.Requests.HospitalClientApi;
import com.simpad.covid_19tracker.Requests.SamplesClientAPi;

import java.util.List;

public class DetailRepository {

    private static DetailRepository instance;

    private static DetailsClientApi detailsClientApi;

    private static SamplesClientAPi samplesClientAPi;

    private static ContactsClientApi contactsClientApi;

    private static HospitalClientApi hospitalClientApi;

    private static DetailedHistoryClientApi detailedHistoryClientApi;

    private static DistrictClientApi districtClientApi;

    public static DetailRepository getInstance(){
        if(instance==null){
            instance = new DetailRepository();
        }
        return instance;
    }

    private DetailRepository(){
        detailsClientApi = DetailsClientApi.getInstance();
        samplesClientAPi = SamplesClientAPi.getInstance();
        contactsClientApi = ContactsClientApi.getInstance();
        hospitalClientApi = HospitalClientApi.getInstance();
        detailedHistoryClientApi = DetailedHistoryClientApi.getInstance();
        districtClientApi = DistrictClientApi.getInstance();
    }


    public LiveData<Details> getDetails() {
        return detailsClientApi.getDetails();
    }

    public void getCompleteDetailApi(){
        detailsClientApi.getDetailApi();
    }

    public LiveData<Sample> getSample(){
        return samplesClientAPi.getSample();
    }

    public void getCompleteSampleApi(){samplesClientAPi.getSampleApi();}

    public LiveData<Contacts> getContacts(){
        return contactsClientApi.getContacts();
    }

    public void getCompleteContactsApi(){contactsClientApi.getContactsApi();}

    public LiveData<Hospital> getHospitals(){
        return hospitalClientApi.getHospitals();
    }

    public void getCompleteHospitalsApi(){hospitalClientApi.getHospitalApi();}

    public LiveData<com.simpad.covid_19tracker.Models.History.Details> getDetailedHistory() {
        return detailedHistoryClientApi.getDetails();
    }

    public void getCompleteDetailedHistoryApi(){
        detailedHistoryClientApi.getDetailApi();
    }

    public LiveData<List<DistrictsDetail>> getDistrict(){
        return districtClientApi.getDetails();
    }
    public void geCompleteDistrictDetailApi(){
        districtClientApi.getDetailApi();
    }
}
