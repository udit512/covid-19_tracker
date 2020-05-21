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

import com.simpad.covid_19tracker.Adapter.StatesRecyclerViewAdapter;
import com.simpad.covid_19tracker.Models.District.DistrictsDetail;
import com.simpad.covid_19tracker.Models.History.Datum;
import com.simpad.covid_19tracker.Models.Regional;
import com.simpad.covid_19tracker.ViewModel.MainActivityViewModel;

import java.util.List;

public class StatesActivity extends AppCompatActivity {

    private static final String TAG = "StatesActivity";
    private RecyclerView stateRecyclerView;
    private ImageView back;
    private TextView updatedOn;
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_states);
        stateRecyclerView = findViewById(R.id.stateRecyclerView);
        back = findViewById(R.id.back);
        updatedOn = findViewById(R.id.updatedTime);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("Regionals");
        String up = bundle.getString("time");
        List<Datum> data = (List<Datum>) bundle.getSerializable("Dataum");
        Log.d(TAG, "onCreate: data"+data.get(0).getDay());
        updatedOn.setText(up);
        List<Regional> regionalList = (List<Regional>) bundle.getSerializable("Regionals");
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mainActivityViewModel.getCompleteDistrictDetailApi();
        mainActivityViewModel.getDistrict().observe(this, new Observer<List<DistrictsDetail>>() {
            @Override
            public void onChanged(List<DistrictsDetail> districtsDetails) {
                for (DistrictsDetail detail : districtsDetails){
                    Log.d(TAG, "onChanged: "+detail.getState());
                    StatesRecyclerViewAdapter statesRecyclerViewAdapter = new StatesRecyclerViewAdapter(StatesActivity.this,regionalList,data,districtsDetails);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(StatesActivity.this);
                    stateRecyclerView.setLayoutManager(linearLayoutManager);
                    stateRecyclerView.setAdapter(statesRecyclerViewAdapter);
                }
            }
        });
    }
}
