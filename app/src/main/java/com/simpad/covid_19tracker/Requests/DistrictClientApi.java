package com.simpad.covid_19tracker.Requests;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.simpad.covid_19tracker.AppExecutors;
import com.simpad.covid_19tracker.Models.Details;
import com.simpad.covid_19tracker.Models.District.DistrictsDetail;
import com.simpad.covid_19tracker.UTILS.Constants;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;

public class DistrictClientApi {
    private static DistrictClientApi instance;
    private MutableLiveData<List<DistrictsDetail>> mDetails;
    private DistrictClientApi.RetreiveDistrictDetailsRunnable retreiveDistrictDetailsRunnable;

    public static DistrictClientApi getInstance(){
        if (instance==null){
            instance = new DistrictClientApi();
        }
        return instance;
    }

    private DistrictClientApi (){
        mDetails = new MutableLiveData<>();
    }

    public LiveData<List<DistrictsDetail>> getDetails(){
        return mDetails;
    }


    public void getDetailApi(){
        if (retreiveDistrictDetailsRunnable!=null)
            retreiveDistrictDetailsRunnable = null;
        retreiveDistrictDetailsRunnable = new DistrictClientApi.RetreiveDistrictDetailsRunnable();
        final Future handler = AppExecutors.getInstance().networkIO().submit(retreiveDistrictDetailsRunnable);

        AppExecutors.getInstance().networkIO().schedule(new Runnable() {
            @Override
            public void run() {
                handler.cancel(true);
            }
        }, Constants.TIME_OUT, TimeUnit.MILLISECONDS);
    }

    private class RetreiveDistrictDetailsRunnable implements Runnable{

        boolean cancelRequest;

        public RetreiveDistrictDetailsRunnable() {
            this.cancelRequest = false;
        }

        @Override
        public void run() {
            try {
                Response response = getDetails().execute();
                if(response.code()==200){
                    List<DistrictsDetail> details = (List<DistrictsDetail>) response.body();
                    mDetails.postValue(details);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(cancelRequest){
                return;
            }
        }

        private Call<List<DistrictsDetail>> getDetails(){
            return ServiceGenerator.getCovidApi().getDistrict();
        }

        private void cancelRequest(){
            cancelRequest = true;
        }
    }
}
