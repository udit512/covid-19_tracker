package com.simpad.covid_19tracker.Requests;

import android.renderscript.ScriptGroup;

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


public class DetailsClientApi {

    private static DetailsClientApi instance;
    private MutableLiveData<Details> mDetails;
    private RetreiveDetailsRunnable retreiveDetailsRunnable;

    public static DetailsClientApi getInstance(){
        if (instance==null){
            instance = new DetailsClientApi();
        }
        return instance;
    }

    private DetailsClientApi (){
        mDetails = new MutableLiveData<>();
    }

    public LiveData<Details> getDetails(){
        return mDetails;
    }


    public void getDetailApi(){
        if (retreiveDetailsRunnable!=null)
            retreiveDetailsRunnable = null;
        retreiveDetailsRunnable = new RetreiveDetailsRunnable();
        final Future handler = AppExecutors.getInstance().networkIO().submit(retreiveDetailsRunnable);

        AppExecutors.getInstance().networkIO().schedule(new Runnable() {
            @Override
            public void run() {
                handler.cancel(true);
            }
        }, Constants.TIME_OUT, TimeUnit.MILLISECONDS);
    }

    private class RetreiveDetailsRunnable implements Runnable{

        boolean cancelRequest;

        public RetreiveDetailsRunnable() {
            this.cancelRequest = false;
        }

        @Override
        public void run() {
            try {
                Response response = getDetails().execute();
                if(response.code()==200){
                    Details details = (Details) response.body();
                    mDetails.postValue(details);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(cancelRequest){
                return;
            }
        }

        private Call<Details> getDetails(){
            return ServiceGenerator.getCovidApi().getDetails();
        }

        private void cancelRequest(){
            cancelRequest = true;
        }
    }


}
