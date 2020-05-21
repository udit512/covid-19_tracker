package com.simpad.covid_19tracker.Requests;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.simpad.covid_19tracker.AppExecutors;
import com.simpad.covid_19tracker.Models.History.Details;
import com.simpad.covid_19tracker.UTILS.Constants;

import java.io.IOException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;

public class DetailedHistoryClientApi {


    private static DetailedHistoryClientApi instance;
    private MutableLiveData<Details> mDetails;
    private DetailedHistoryClientApi.RetreiveDetailHistoryRunnable retreiveDetailHistoryRunnable;

    public static DetailedHistoryClientApi getInstance(){
        if (instance==null){
            instance = new DetailedHistoryClientApi();
        }
        return instance;
    }

    private DetailedHistoryClientApi (){
        mDetails = new MutableLiveData<>();
    }

    public LiveData<Details> getDetails(){
        return mDetails;
    }


    public void getDetailApi(){
        if (retreiveDetailHistoryRunnable!=null)
            retreiveDetailHistoryRunnable = null;
        retreiveDetailHistoryRunnable = new DetailedHistoryClientApi.RetreiveDetailHistoryRunnable();
        final Future handler = AppExecutors.getInstance().networkIO().submit(retreiveDetailHistoryRunnable);

        AppExecutors.getInstance().networkIO().schedule(new Runnable() {
            @Override
            public void run() {
                handler.cancel(true);
            }
        }, Constants.TIME_OUT, TimeUnit.MILLISECONDS);
    }

    private class RetreiveDetailHistoryRunnable implements Runnable{

        boolean cancelRequest;

        public RetreiveDetailHistoryRunnable() {
            this.cancelRequest = false;
        }

        @Override
        public void run() {
            try {
                Response response = getHistoryDetails().execute();
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

        private Call<Details> getHistoryDetails(){
            return ServiceGenerator.getCovidApi().getDetailedHistory();
        }

        private void cancelRequest(){
            cancelRequest = true;
        }
    }


}
