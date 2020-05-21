package com.simpad.covid_19tracker.Requests;

import com.simpad.covid_19tracker.UTILS.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    private static Retrofit retrofit = retrofitBuilder.build();

    private static CovidApi covidApi = retrofit.create(CovidApi.class);

    public static CovidApi getCovidApi(){
        return covidApi;
    }

}
