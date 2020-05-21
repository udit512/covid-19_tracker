package com.simpad.covid_19tracker.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.simpad.covid_19tracker.R;

import java.util.List;

public class PrecautionsRecyclerViewAdapter extends RecyclerView.Adapter<PrecautionsRecyclerViewAdapter.ViewHolder> {

    private List<Integer> imageURl;
    private List<String> symptoms;
    private Context context;

    public PrecautionsRecyclerViewAdapter(Context context, List<Integer> imageURl, List<String> symptoms) {
        this.imageURl = imageURl;
        this.symptoms = symptoms;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.symptoms_item_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.symptomsImage.setImageResource(imageURl.get(position));
        holder.symptomText.setText(symptoms.get(position));
    }

    @Override
    public int getItemCount() {
        return imageURl.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView symptomsImage;
        private TextView symptomText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            symptomsImage = itemView.findViewById(R.id.symptomsImage);
            symptomText = itemView.findViewById(R.id.symptomsText);
        }
    }
}
