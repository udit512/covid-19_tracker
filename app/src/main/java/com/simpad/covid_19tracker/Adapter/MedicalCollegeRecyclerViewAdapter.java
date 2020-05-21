package com.simpad.covid_19tracker.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.simpad.covid_19tracker.Models.ContactDetails.Regional;
import com.simpad.covid_19tracker.Models.Hospitals.MedicalCollege;
import com.simpad.covid_19tracker.R;

import java.util.List;

public class MedicalCollegeRecyclerViewAdapter extends RecyclerView.Adapter<MedicalCollegeRecyclerViewAdapter.ViewHolder> {

    private List<MedicalCollege> medicalCollegeList;
    private Context context;

    public MedicalCollegeRecyclerViewAdapter(Context context, List<MedicalCollege> medicalColleges) {
        this.medicalCollegeList = medicalColleges;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.medical_college_list_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MedicalCollege medicalCollege = medicalCollegeList.get(position);
        holder.hospitalName.setText(medicalCollege.getName());
        holder.stateNumber.setText(medicalCollege.getState());
        holder.cityNumber.setText(medicalCollege.getCity());

    }

    @Override
    public int getItemCount() {
        return medicalCollegeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView hospitalName;
        private TextView stateNumber;
        private TextView cityNumber;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hospitalName = itemView.findViewById(R.id.hospitalName);
            stateNumber = itemView.findViewById(R.id.stateName);
            cityNumber = itemView.findViewById(R.id.cityName);
        }
    }
}
