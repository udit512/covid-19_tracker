package com.simpad.covid_19tracker.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.simpad.covid_19tracker.Models.ContactDetails.Contacts;
import com.simpad.covid_19tracker.Models.ContactDetails.Regional;
import com.simpad.covid_19tracker.R;

import java.util.List;

public class ContactsRecyclerViewAdapter extends RecyclerView.Adapter<ContactsRecyclerViewAdapter.ViewHolder> {

    private List<Regional> regionalList;
    private Context context;

    public ContactsRecyclerViewAdapter(Context context,List<Regional> regionalList) {
        this.regionalList = regionalList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.state_helpline_view_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Regional regional = regionalList.get(position);
        holder.stateName.setText(regional.getLoc());
        holder.helplineNumber.setText(regional.getNumber());
        holder.helplineNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+regional.getNumber()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return regionalList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView stateName;
        private TextView helplineNumber;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            stateName = itemView.findViewById(R.id.textState);
            helplineNumber = itemView.findViewById(R.id.number);
        }
    }
}
