package com.simpad.covid_19tracker.Requests;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.simpad.covid_19tracker.AppExecutors;
import com.simpad.covid_19tracker.Models.ContactDetails.Contacts;
import com.simpad.covid_19tracker.Models.Details;
import com.simpad.covid_19tracker.UTILS.Constants;

import java.io.IOException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Response;

public class ContactsClientApi {

    private static ContactsClientApi instance;
    private MutableLiveData<Contacts> mContacts;
    private RetreiveContactsRunnable retreiveContactsRunnable;

    public static ContactsClientApi getInstance(){
        if(instance==null)
            instance = new ContactsClientApi();
        return instance;
    }

    private ContactsClientApi(){
        mContacts = new MutableLiveData<>();
    }

    public LiveData<Contacts> getContacts(){return mContacts;}


    public void getContactsApi(){
        if (retreiveContactsRunnable!=null)
            retreiveContactsRunnable = null;
        retreiveContactsRunnable = new ContactsClientApi.RetreiveContactsRunnable();
        final Future handler = AppExecutors.getInstance().networkIO().submit(retreiveContactsRunnable);

        AppExecutors.getInstance().networkIO().schedule(new Runnable() {
            @Override
            public void run() {
                handler.cancel(true);
            }
        }, Constants.TIME_OUT, TimeUnit.MILLISECONDS);
    }


    private class RetreiveContactsRunnable implements Runnable{

        boolean cancelRequest;

        public RetreiveContactsRunnable() {
            this.cancelRequest = false;
        }

        @Override
        public void run() {
            try {
                Response response = getContacts().execute();
                if(response.code()==200){
                    Contacts contacts = (Contacts) response.body();
                    mContacts.postValue(contacts);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(cancelRequest){
                return;
            }
        }

        private Call<Contacts> getContacts(){
            return ServiceGenerator.getCovidApi().getContacts();
        }

        private void cancelRequest(){
            cancelRequest = true;
        }
    }

}
