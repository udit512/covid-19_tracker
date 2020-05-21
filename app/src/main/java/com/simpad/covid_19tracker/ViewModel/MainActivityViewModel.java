package com.simpad.covid_19tracker.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.simpad.covid_19tracker.Models.ContactDetails.Contacts;
import com.simpad.covid_19tracker.Models.Details;
import com.simpad.covid_19tracker.Models.District.DistrictsDetail;
import com.simpad.covid_19tracker.Models.Hospitals.Hospital;
import com.simpad.covid_19tracker.Models.SamplesTested.Sample;
import com.simpad.covid_19tracker.Repositories.DetailRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private static DetailRepository detailRepository;

    public MainActivityViewModel(){
        detailRepository = DetailRepository.getInstance();
    }

    public LiveData<Details> getDetails() {
        return detailRepository.getDetails();
    }

    public void getCompleteDetailApi(){
        detailRepository.getCompleteDetailApi();
    }

    public LiveData<Sample> getSample(){
        return detailRepository.getSample();
    }

    public void getCompleteSampleApi(){detailRepository.getCompleteSampleApi();}

    public LiveData<Contacts> getContacts(){
        return detailRepository.getContacts();
    }

    public void getCompleteContactsApi(){detailRepository.getCompleteContactsApi();}

    public LiveData<Hospital> getHospitals(){
        return detailRepository.getHospitals();
    }

    public void getCompleteHospitalsApi(){detailRepository.getCompleteHospitalsApi();}

    public LiveData<com.simpad.covid_19tracker.Models.History.Details> getDetailedHistory() {
        return detailRepository.getDetailedHistory();
    }

    public void getCompleteDetailedHistoryApi(){
        detailRepository.getCompleteDetailedHistoryApi();
    }

    public LiveData<List<DistrictsDetail>> getDistrict(){return detailRepository.getDistrict();}

    public void getCompleteDistrictDetailApi(){detailRepository.geCompleteDistrictDetailApi();}
}
