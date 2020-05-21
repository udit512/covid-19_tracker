package com.simpad.covid_19tracker.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.simpad.covid_19tracker.DistrictActivity;
import com.simpad.covid_19tracker.Models.District.DistrictsDetail;
import com.simpad.covid_19tracker.Models.History.Datum;
import com.simpad.covid_19tracker.Models.Regional;
import com.simpad.covid_19tracker.R;
import com.simpad.covid_19tracker.ViewModel.MainActivityViewModel;

import java.io.Serializable;
import java.util.List;

import static android.content.ContentValues.TAG;

public class StatesRecyclerViewAdapter extends RecyclerView.Adapter<StatesRecyclerViewAdapter.ViewHolder> {

    private List<Regional> regionalList;
    private List<DistrictsDetail> districtsDetails;
    private List<Datum> data;
    private Context context;

    public StatesRecyclerViewAdapter(Context context,List<Regional> regionalList,List<Datum> data,List<DistrictsDetail> districtsDetails) {
        this.regionalList = regionalList;
        this.context = context;
        this.data = data;
        this.districtsDetails = districtsDetails;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.state_view_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Regional regional = regionalList.get(position);
        DistrictsDetail districtsDetail = districtsDetails.get(position);
        int size = data.size();
//        holder.StateConfirmedCases.setText(String.valueOf(regional.getTotalConfirmed()));
//        holder.StateName.setText(regional.getLoc());
//        holder.StateRecoveredCases.setText(String.valueOf(regional.getDischarged()));
//        holder.StateDeathCases.setText(String.valueOf(regional.getDeaths()));
        holder.StateConfirmedCases.setText(String.valueOf(districtsDetail.getConfirmed()));
        holder.StateName.setText(districtsDetail.getState());
        holder.StateRecoveredCases.setText(String.valueOf(districtsDetail.getRecovered()));
        holder.StateDeathCases.setText(String.valueOf(districtsDetail.getDeaths()));





        List<com.simpad.covid_19tracker.Models.History.Regional> regionalPresent = data.get(size-1).getRegional();
        List<com.simpad.covid_19tracker.Models.History.Regional> regionalYesterday = data.get(size-2).getRegional();
        long presentC=0,presentR= 0,presentD= 0,yesterdayC= 0,yesterdayR= 0,yesterdayD= 0;
        for(com.simpad.covid_19tracker.Models.History.Regional regional1 : regionalPresent){
            if(regional1!=null && regional1.getLoc().toLowerCase().equals(districtsDetail.getState().toLowerCase())){
                Log.d(TAG, "onBindViewHolder: fg"+regional1.getTotalConfirmed());
                presentC=regional1.getTotalConfirmed();
                presentR=regional1.getDischarged();
                presentD = regional1.getDeaths();
                break;
            }
        }
        for(com.simpad.covid_19tracker.Models.History.Regional regional1 : regionalYesterday){
            if(regional1!=null && regional1.getLoc().toLowerCase().equals(districtsDetail.getState().toLowerCase())){
                yesterdayC=regional1.getTotalConfirmed();
                yesterdayR=regional1.getDischarged();
                yesterdayD = regional1.getDeaths();
                break;
            }
        }

        //Log.d(TAG, "onBindViewHolder: "+presentC+yesterdayC);
        long todayc=  (presentC-yesterdayC);
        long todayr=  (presentR-yesterdayR);
        long todayd=  (presentD-yesterdayD);


        holder.StateTodayConfirmed.setText("+"+todayc);
        holder.StateTodayRecovered.setText("+"+todayr);
        holder.StateTodayDeath.setText("+"+todayd);

        holder.stateCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DistrictActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", (Serializable) data);
                bundle.putString("stateName",districtsDetail.getState());
                intent.putExtra("district",bundle);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return regionalList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView StateConfirmedCases;
        private TextView StateRecoveredCases;
        private TextView StateDeathCases;
        private TextView StateName;
        private TextView StateTodayConfirmed;
        private TextView StateTodayRecovered;
        private TextView StateTodayDeath;
        private CardView stateCardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            StateConfirmedCases = itemView.findViewById(R.id.StateConfirmedCases);
            StateRecoveredCases = itemView.findViewById(R.id.StateRecoveredCases);
            StateDeathCases = itemView.findViewById(R.id.StateDeathCases);
            StateName = itemView.findViewById(R.id.textState);
            StateTodayConfirmed = itemView.findViewById(R.id.stateTodayConfirmed);
            StateTodayRecovered = itemView.findViewById(R.id.stateTodayRecovered);
            StateTodayDeath = itemView.findViewById(R.id.stateTodayDeath);
            stateCardView = itemView.findViewById(R.id.stateCardView);
        }
    }
}
