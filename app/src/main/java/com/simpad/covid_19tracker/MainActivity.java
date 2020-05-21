package com.simpad.covid_19tracker;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.simpad.covid_19tracker.Adapter.SymptomsRecyclerViewAdapter;
import com.simpad.covid_19tracker.Models.Data;
import com.simpad.covid_19tracker.Models.Details;
import com.simpad.covid_19tracker.Models.History.Datum;
import com.simpad.covid_19tracker.Models.Regional;
import com.simpad.covid_19tracker.Models.SamplesTested.Sample;
import com.simpad.covid_19tracker.Models.Summary;
import com.simpad.covid_19tracker.Models.UnofficialSummary;
import com.simpad.covid_19tracker.Requests.CovidApi;
import com.simpad.covid_19tracker.Requests.ServiceGenerator;
import com.simpad.covid_19tracker.ViewModel.MainActivityViewModel;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mainActivityViewModel;
    private static final String TAG = "MainActivity";
    private TextView AcrossIndiaConfirmedCases;
    private TextView AcrossIndiaRecoveredCases;
    private TextView AcrossIndiaDeathCases;
    private TextView stateText;
    private TextView StateConfirmedCases;
    private TextView StateRecoveredCases;
    private TextView StateDeathCases;
    private TextView TotalNumberSample;
    private TextView updatedTime;
    private RecyclerView symptomsRecyclerView;
    private RecyclerView precautionsRecyclerView;
    private List<Integer> imageId;
    private List<String> symptoms;
    private List<Integer> pimageId;
    private List<Datum> data;
    private List<String> precautions;
    private CardView stateWise;
    private CardView contacts;
    private CardView medicalColleges;
    private CardView creator;
    private List<Regional> regionalList;
    private String up;
    private AdView mAdView;
    private Double latitude;
    private Double longtitude;
    private String State;
    private TextView todayConfirmed;
    private TextView todayRecovered;
    private TextView todayDeceased;
    private TextView todayStateConfirmed;
    private TextView todayStateRecovered;
    private TextView todayStateDeath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        latitude = Double.parseDouble(intent.getStringExtra("latitude"));
        longtitude = Double.parseDouble(intent.getStringExtra("longtiude"));
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());

        List<Address> addresses  = null;
        try {
            addresses = geocoder.getFromLocation(latitude,longtitude, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        State = addresses.get(0).getAdminArea();
        String country = addresses.get(0).getCountryName();
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mainActivityViewModel.getCompleteDetailApi();
        mainActivityViewModel.getCompleteSampleApi();
        mainActivityViewModel.getCompleteDetailedHistoryApi();
        stateText = findViewById(R.id.textState);
        symptomsRecyclerView = findViewById(R.id.symptomsRecyclerView);
        precautionsRecyclerView = findViewById(R.id.precautionsRecyclerView);
        updatedTime = findViewById(R.id.updated_time);
        todayConfirmed = findViewById(R.id.todayConfirmed);
        todayDeceased = findViewById(R.id.todayDeceased);
        todayRecovered = findViewById(R.id.todayRecovered);
        imageId = new ArrayList<>();
        symptoms = new ArrayList<>();
        pimageId = new ArrayList<>();
        precautions = new ArrayList<>();
        regionalList = new ArrayList<>();
        creator = findViewById(R.id.creator);
        todayStateConfirmed = findViewById(R.id.todayStateConfirmed);
        todayStateRecovered = findViewById(R.id.todayStateRecovered);
        todayStateDeath = findViewById(R.id.todayStateDeath);
        add(R.drawable.fever,"FEVER");
        add(R.drawable.cough,"COUGH");
        add(R.drawable.chest_pain,"CHEST PAIN");
        add(R.drawable.headache,"HEAD ACHE");
        add(R.drawable.skin_rash,"SKIN RASH");
        add(R.drawable.sore_throat,"SORE THROAT");
        addPre(R.drawable.hand_wash,"HAND WASH");
        addPre(R.drawable.cover_face,"COVER FACE");
        addPre(R.drawable.mask,"WEAR MASK");
        addPre(R.drawable.social_distancing,"SOCIAL DISTANCING");
        addPre(R.drawable.sanitiza,"SANITATION");
        addPre(R.drawable.stay_home,"STAY HOME");
        SymptomsRecyclerViewAdapter symptomsRecyclerViewAdapter = new SymptomsRecyclerViewAdapter(this,imageId,symptoms);
        SymptomsRecyclerViewAdapter precautionsRecyclerViewAdapter = new SymptomsRecyclerViewAdapter(this,pimageId,precautions);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true);
        symptomsRecyclerView.setLayoutManager(linearLayoutManager);
        symptomsRecyclerView.setAdapter(symptomsRecyclerViewAdapter);
        precautionsRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true));
        precautionsRecyclerView.setAdapter(precautionsRecyclerViewAdapter);
        subscribeObservers();
        //test();
        //testing();
        //testRetrofitRequest();
        AcrossIndiaConfirmedCases = findViewById(R.id.AcrossIndiaConfirmedCases);
        AcrossIndiaRecoveredCases = findViewById(R.id.AcrossIndiaRecoveredCases);
        AcrossIndiaDeathCases = findViewById(R.id.AcrossIndiaDeathsCases);
        StateConfirmedCases = findViewById(R.id.StateConfirmedCases);
        StateRecoveredCases = findViewById(R.id.StateRecoveredCases);
        StateDeathCases = findViewById(R.id.StateDeathCases);
        TotalNumberSample = findViewById(R.id.textNumberSample);
        stateWise = findViewById(R.id.stateWise);
        contacts = findViewById(R.id.helpLine);
        medicalColleges = findViewById(R.id.medicalColleges);
        creator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CreatorActivity.class);
                startActivity(intent);
            }
        });
        medicalColleges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HospitalsActivity.class);
                startActivity(intent);
            }
        });
        contacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ContactsActivity.class);
                intent.putExtra("time",up);
                startActivity(intent);
            }
        });
        stateWise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,StatesActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("Regionals", (Serializable) regionalList);
                bundle.putSerializable("Dataum", (Serializable) data);
                bundle.putString("time",up);
                intent.putExtra("Regionals",bundle);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        mainActivityViewModel.getCompleteDetailApi();
        mainActivityViewModel.getCompleteSampleApi();
        mainActivityViewModel.getCompleteDetailedHistoryApi();

    }

    @Override
    protected void onPause() {
        super.onPause();
        mainActivityViewModel.getCompleteDetailApi();
        mainActivityViewModel.getCompleteSampleApi();
        mainActivityViewModel.getCompleteDetailedHistoryApi();

    }

    private void testing(){
        mainActivityViewModel.getSample().observe(this, new Observer<Sample>() {
            @Override
            public void onChanged(Sample sample) {
                com.simpad.covid_19tracker.Models.SamplesTested.Data data = sample.getData();
                Log.d(TAG, "onChanged: "+data.getTotalSamplesTested());
                TotalNumberSample.setText(String.valueOf(data.getTotalSamplesTested()));

            }
        });
    }

    public void add(Integer id,String symtom){
        imageId.add(id);
        symptoms.add(symtom);
    }
    public void addPre(Integer id,String precaution){
        pimageId.add(id);
        precautions.add(precaution);
    }



    public void testRetrofitRequest() {
        CovidApi covidApi = ServiceGenerator.getCovidApi();
        Call<Sample> response = covidApi.getSamples();
        response.enqueue(new Callback<Sample>() {
            @Override
            public void onResponse(Call<Sample> call, Response<Sample> response) {
                Sample sample = response.body();
                com.simpad.covid_19tracker.Models.SamplesTested.Data data = sample.getData();
                Log.d(TAG, "onResponse: " + data.getTotalSamplesTested());
            }

            @Override
            public void onFailure(Call<Sample> call, Throwable t) {

            }
        });
    }



    private void historyData(){
        mainActivityViewModel.getDetailedHistory().observe(this, new Observer<com.simpad.covid_19tracker.Models.History.Details>() {
            @Override
            public void onChanged(com.simpad.covid_19tracker.Models.History.Details details) {
                data = details.getData();
                int size = data.size();
                Log.d(TAG, "onChanged: l"+String.valueOf(data.get(size-1).getSummary().getTotal()-data.get(size-2).getSummary().getTotal()));
                    todayConfirmed.setText("+"+(data.get(size-1).getSummary().getTotal()-data.get(size-2).getSummary().getTotal()));
                    todayRecovered.setText("+"+(data.get(size-1).getSummary().getDischarged()-data.get(size-2).getSummary().getDischarged()));
                    todayDeceased.setText("+"+(data.get(size-1).getSummary().getDeaths()-data.get(size-2).getSummary().getDeaths()));

                List<com.simpad.covid_19tracker.Models.History.Regional> regionalPresent = data.get(size-1).getRegional();
                List<com.simpad.covid_19tracker.Models.History.Regional> regionalYesterday = data.get(size-2).getRegional();
                Long presentC=null,presentR=null,presentD=null,yesterdayC=null,yesterdayR=null,yesterdayD=null;
                for(com.simpad.covid_19tracker.Models.History.Regional regional : regionalPresent){
                    if(regional!=null && regional.getLoc().toLowerCase().equals(State.toLowerCase())){
                        presentC=regional.getTotalConfirmed();
                        presentR=regional.getDischarged();
                        presentD = regional.getDeaths();
                        break;
                    }
                }
                for(com.simpad.covid_19tracker.Models.History.Regional regional : regionalYesterday){
                    if(regional!=null && regional.getLoc().toLowerCase().equals(State.toLowerCase())){
                        yesterdayC=regional.getTotalConfirmed();
                        yesterdayR=regional.getDischarged();
                        yesterdayD = regional.getDeaths();
                        break;
                    }
                }
                todayStateConfirmed.setText("+"+(presentC-yesterdayC));
                todayStateRecovered.setText("+"+(presentR-yesterdayR));
                todayStateDeath.setText("+"+(presentD-yesterdayD));



//                for(Datum datum : data){
//                    List<com.simpad.covid_19tracker.Models.History.Regional> regionals = datum.getRegional();
//                    Log.d(TAG, "onChanged: "+datum.getDay());
//                }

            }
        });
    }




    private void subscribeObservers() {
        mainActivityViewModel.getDetails().observe(this, new Observer<Details>() {
            @Override
            public void onChanged(Details details) {
                    String updatedOn = details.getLastRefreshed();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                try {
                    Date date = dateFormat.parse(updatedOn);
                    up = "Updated on "+date;
                    updatedTime.setText("Updated on "+date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Data data = details.getData();
                    Summary summary = data.getSummary();
                    List<UnofficialSummary> unofficialSummary = data.getUnofficialSummary();
                    long Confirmed = summary.getTotal();
                    long Recovered = summary.getDischarged();
                    long Deaths = summary.getDeaths();
                    if(summary.getTotal()!=0){
                        AcrossIndiaConfirmedCases.setText(String.valueOf(Confirmed));
                        AcrossIndiaRecoveredCases.setText(String.valueOf(Recovered));
                        AcrossIndiaDeathCases.setText(String.valueOf(Deaths));
                    }
                    else {
                        AcrossIndiaConfirmedCases.setText(String.valueOf(unofficialSummary.get(0).getTotal()));
                        AcrossIndiaRecoveredCases.setText(String.valueOf(unofficialSummary.get(0).getRecovered()));
                        AcrossIndiaDeathCases.setText(String.valueOf(unofficialSummary.get(0).getDeaths()));
                    }
                    regionalList = data.getRegional();
                for (Regional regional : regionalList){
                    String loc = regional.getLoc();
                    Log.d(TAG, "onChanged: lk"+loc);
                    if(loc.toLowerCase().equals(State.toLowerCase())){
                        stateText.setText(State);
                        StateConfirmedCases.setText(String.valueOf(regional.getTotalConfirmed()));
                        StateRecoveredCases.setText(String.valueOf(regional.getDischarged()));
                        StateDeathCases.setText(String.valueOf(regional.getDeaths()));
                        break;
                    }
                }
                    testing();
                    historyData();
            }
        });
    }
}