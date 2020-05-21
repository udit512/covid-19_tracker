package com.simpad.covid_19tracker.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.simpad.covid_19tracker.DistrictActivity;
import com.simpad.covid_19tracker.Models.District.DistrictDatum;
import com.simpad.covid_19tracker.Models.District.DistrictsDetail;
import com.simpad.covid_19tracker.Models.History.Datum;
import com.simpad.covid_19tracker.Models.Regional;
import com.simpad.covid_19tracker.R;

import java.io.Serializable;
import java.util.List;

import static android.content.ContentValues.TAG;

public class DistrictRecyclerViewAdapter extends RecyclerView.Adapter<DistrictRecyclerViewAdapter.ViewHolder> {

    private List<DistrictDatum> districtData;
    private Context context;

    public DistrictRecyclerViewAdapter(Context context,List<DistrictDatum> districtData) {

        this.context = context;
        this.districtData = districtData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.district_list_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.DistrictName.setText(districtData.get(position).getName());
        holder.DistrictConfirmedCases.setText("Confirmed Cases: "+districtData.get(position).getConfirmed());
        holder.DistrictZone.setText("Zone:  "+districtData.get(position).getZone());
        if(districtData.get(position).getZone().equals("RED")){
            holder.DistrictCardView.setCardBackgroundColor(Color.parseColor("#f64b3c"));
        }
        else if(districtData.get(position).getZone().equals("GREEN")){
            holder.DistrictCardView.setCardBackgroundColor(Color.parseColor("#50d890"));
        }
        else {
            holder.DistrictCardView.setCardBackgroundColor(Color.parseColor("#f37121"));
        }

    }

    @Override
    public int getItemCount() {
        return districtData.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView DistrictName;
        private TextView DistrictConfirmedCases;
        private TextView DistrictZone;
        private CardView DistrictCardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            DistrictName = itemView.findViewById(R.id.districtName);
            DistrictConfirmedCases = itemView.findViewById(R.id.DistrictConfirmedCases);
            DistrictZone = itemView.findViewById(R.id.districtZone);
            DistrictCardView = itemView.findViewById(R.id.districtCardView);
        }
    }
}
