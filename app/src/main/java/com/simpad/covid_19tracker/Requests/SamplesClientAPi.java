package com.simpad.covid_19tracker.Requests;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.simpad.covid_19tracker.AppExecutors;
import com.simpad.covid_19tracker.Models.Details;
import com.simpad.covid_19tracker.Models.SamplesTested.Sample;
import com.simpad.covid_19tracker.UTILS.Constants;

import java.io.IOException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;

public class SamplesClientAPi {
    private static SamplesClientAPi instance;
    private MutableLiveData<Sample> mSample;
    private RetreiveSamplesApi retreiveSamplesApi;

    public static SamplesClientAPi getInstance(){
        if(instance == null ){
            instance = new SamplesClientAPi();
        }
        return instance;
    }

    public LiveData<Sample> getSample(){
        return mSample;
    }

    private SamplesClientAPi(){
        mSample = new MutableLiveData<>();
    }

    public void getSampleApi(){
        if(retreiveSamplesApi!=null){
            retreiveSamplesApi=null;
        }
        retreiveSamplesApi = new RetreiveSamplesApi();
        final Future handler = AppExecutors.getInstance().networkIO().submit(retreiveSamplesApi);

        AppExecutors.getInstance().networkIO().schedule(new Runnable() {
            @Override
            public void run() {
                handler.cancel(true);
            }
        }, Constants.TIME_OUT, TimeUnit.MILLISECONDS);
    }

    private class RetreiveSamplesApi implements Runnable{

        boolean cancelRequest;

        private void cancelRequest(){
            cancelRequest = true;
        }


        public RetreiveSamplesApi() {
            this.cancelRequest = false;
        }

        private Call<Sample> getSample(){
            return ServiceGenerator.getCovidApi().getSamples();
        }

        @Override
        public void run() {
            try {
                Response response = getSample().execute();
                if(response.code()==200){
                    Sample sample = (Sample) response.body();
                    mSample.postValue(sample);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(cancelRequest){
                return;
            }
        }
    }



}
