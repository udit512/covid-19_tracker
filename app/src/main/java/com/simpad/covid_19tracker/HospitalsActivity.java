package com.simpad.covid_19tracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.simpad.covid_19tracker.Adapter.MedicalCollegeRecyclerViewAdapter;
import com.simpad.covid_19tracker.Models.Hospitals.Data;
import com.simpad.covid_19tracker.Models.Hospitals.Hospital;
import com.simpad.covid_19tracker.Models.Hospitals.MedicalCollege;
import com.simpad.covid_19tracker.ViewModel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class HospitalsActivity extends AppCompatActivity {

    private static final String TAG = "HospitalsActivity";

    private MainActivityViewModel mainActivityViewModel;

    private RecyclerView recyclerView;

    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);
        mainActivityViewModel = new MainActivityViewModel();
        mainActivityViewModel.getCompleteHospitalsApi();
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        recyclerView = findViewById(R.id.medicalCollegeRecylerView);
        subscribeObservers();
    }

    public void subscribeObservers(){
        mainActivityViewModel.getHospitals().observe(this, new Observer<Hospital>() {
            @Override
            public void onChanged(Hospital hospital) {
                Data data = hospital.getData();
                List<MedicalCollege> medicalColleges = data.getMedicalColleges();
                MedicalCollegeRecyclerViewAdapter medicalCollegeRecyclerViewAdapter = new MedicalCollegeRecyclerViewAdapter(HospitalsActivity.this,medicalColleges);
                recyclerView.setLayoutManager(new LinearLayoutManager(HospitalsActivity.this));
                recyclerView.setAdapter(medicalCollegeRecyclerViewAdapter);
            }
        });
    }
}
