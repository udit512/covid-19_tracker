package com.simpad.covid_19tracker.Requests;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.simpad.covid_19tracker.AppExecutors;
import com.simpad.covid_19tracker.Models.Hospitals.Hospital;
import com.simpad.covid_19tracker.UTILS.Constants;

import java.io.IOException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;

public class HospitalClientApi {
    private static HospitalClientApi instance;
    private MutableLiveData<Hospital> hospitals;
    private RetreiveHospitalDetails retreiveHospitalDetails;

    public static HospitalClientApi getInstance(){
        if(instance == null )
            instance = new HospitalClientApi();
        return instance;
    }

    private HospitalClientApi(){
        hospitals = new MutableLiveData<>();
    }

    public LiveData<Hospital> getHospitals(){
        return hospitals;
    }

    public void getHospitalApi(){
        if(retreiveHospitalDetails!=null)
            retreiveHospitalDetails = null;
        retreiveHospitalDetails = new RetreiveHospitalDetails();
        final Future handler = AppExecutors.getInstance().networkIO().submit(retreiveHospitalDetails);
        AppExecutors.getInstance().networkIO().schedule(new Runnable() {
            @Override
            public void run() {
                handler.cancel(true);
            }
        }, Constants.TIME_OUT, TimeUnit.MILLISECONDS);
    }


    private class RetreiveHospitalDetails implements Runnable{

        boolean cancelRequest;

        public RetreiveHospitalDetails(){
            this.cancelRequest = false;
        }

        @Override
        public void run() {

            try {
                Response response = getHospitals().execute();
                if(response.code()==200){
                    Hospital hospital = (Hospital) response.body();
                    hospitals.postValue(hospital);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(cancelRequest)
                return;
        }

        private Call<Hospital> getHospitals(){
            return ServiceGenerator.getCovidApi().getHospitals();
        }

        private void cancelREquest(){
            cancelRequest=true;
        }
    }

}
