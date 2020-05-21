package com.simpad.covid_19tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.simpad.covid_19tracker.Adapter.DistrictRecyclerViewAdapter;
import com.simpad.covid_19tracker.Models.District.DistrictDatum;
import com.simpad.covid_19tracker.Models.District.DistrictsDetail;
import com.simpad.covid_19tracker.Models.History.Datum;
import com.simpad.covid_19tracker.ViewModel.MainActivityViewModel;

import java.util.List;

import static android.content.ContentValues.TAG;

public class DistrictActivity extends AppCompatActivity {

    private List<DistrictsDetail> districtsDetails;
    private List<Datum> data;
    private String stateName;
    private static final String TAG = "DistrictActivity";
    private ImageView back;
    private MainActivityViewModel mainActivityViewModel;
    private TextView StateConfirmedCases;
    private TextView StateRecoveredCases;
    private TextView StateDeathCases;
    private TextView StateName;
    private TextView StateTodayConfirmed;
    private TextView StateTodayRecovered;
    private TextView StateTodayDeath;
    private TextView overViewText;
    private RecyclerView districtRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_district);
        back = findViewById(R.id.back);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("district");
        data = (List<Datum>) bundle.getSerializable("data");
        stateName = bundle.getString("stateName");


        StateConfirmedCases = findViewById(R.id.StateConfirmedCases);
        StateRecoveredCases = findViewById(R.id.StateRecoveredCases);
        StateDeathCases = findViewById(R.id.StateDeathCases);
        StateName = findViewById(R.id.textState);
        StateTodayConfirmed = findViewById(R.id.stateTodayConfirmed);
        StateTodayRecovered = findViewById(R.id.stateTodayRecovered);
        StateTodayDeath = findViewById(R.id.stateTodayDeath);
        overViewText = findViewById(R.id.overviewText);
        districtRecyclerView = findViewById(R.id.districtRecyclerView);


        overViewText.setText((stateName+" State Overview").toUpperCase());

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mainActivityViewModel.getCompleteDistrictDetailApi();
        mainActivityViewModel.getDistrict().observe(this, new Observer<List<DistrictsDetail>>() {
            @Override
            public void onChanged(List<DistrictsDetail> districtsDetails) {
                int size = data.size();
                for(DistrictsDetail districtsDetail : districtsDetails){
                    if (districtsDetail.getState().toLowerCase().equals(stateName.toLowerCase())){
                        StateName.setText(districtsDetail.getState());
                        StateConfirmedCases.setText(String.valueOf(districtsDetail.getConfirmed()));
                        StateRecoveredCases.setText(String.valueOf(districtsDetail.getRecovered()));
                        StateDeathCases.setText(String.valueOf(districtsDetail.getDeaths()));
                        Log.d(TAG, "onChanged: check"+data.get(0).getDay());

                        List<DistrictDatum> districtData = districtsDetail.getDistrictData();
                        DistrictRecyclerViewAdapter districtRecyclerViewAdapter = new DistrictRecyclerViewAdapter(DistrictActivity.this,districtData);
                        districtRecyclerView.setLayoutManager(new LinearLayoutManager(DistrictActivity.this));
                        districtRecyclerView.setAdapter(districtRecyclerViewAdapter);

                    }
                    List<com.simpad.covid_19tracker.Models.History.Regional> regionalPresent = data.get(size-1).getRegional();
                    List<com.simpad.covid_19tracker.Models.History.Regional> regionalYesterday = data.get(size-2).getRegional();
                    long presentC=0,presentR= 0,presentD= 0,yesterdayC= 0,yesterdayR= 0,yesterdayD= 0;
                    for(com.simpad.covid_19tracker.Models.History.Regional regional1 : regionalPresent){
                        if(regional1!=null && regional1.getLoc().toLowerCase().equals(stateName.toLowerCase())){
                            Log.d(TAG, "onBindViewHolder: fg"+regional1.getTotalConfirmed());
                            presentC=regional1.getTotalConfirmed();
                            presentR=regional1.getDischarged();
                            presentD = regional1.getDeaths();
                            break;
                        }
                    }
                    for(com.simpad.covid_19tracker.Models.History.Regional regional1 : regionalYesterday){
                        if(regional1!=null && regional1.getLoc().toLowerCase().equals(stateName.toLowerCase())){
                            yesterdayC=regional1.getTotalConfirmed();
                            yesterdayR=regional1.getDischarged();
                            yesterdayD = regional1.getDeaths();
                            break;
                        }
                    }

                    long todayc=  (presentC-yesterdayC);
                    long todayr=  (presentR-yesterdayR);
                    long todayd=  (presentD-yesterdayD);


                    StateTodayConfirmed.setText("+"+todayc);
                    StateTodayRecovered.setText("+"+todayr);
                    StateTodayDeath.setText("+"+todayd);
                }



            }
        });



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });



    }
}
