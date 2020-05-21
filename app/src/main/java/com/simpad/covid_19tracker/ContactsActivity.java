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

import com.simpad.covid_19tracker.Adapter.ContactsRecyclerViewAdapter;
import com.simpad.covid_19tracker.Models.ContactDetails.Contacts;
import com.simpad.covid_19tracker.Models.ContactDetails.Contacts_;
import com.simpad.covid_19tracker.Models.ContactDetails.Data;
import com.simpad.covid_19tracker.Models.ContactDetails.Regional;
import com.simpad.covid_19tracker.ViewModel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class ContactsActivity extends AppCompatActivity {

    private static final String TAG = "ContactsActivity";
    private MainActivityViewModel mainActivityViewModel ;
    private List<Regional> regionalList ;
    private RecyclerView contactRecyclerView;
    private ImageView back;
    private TextView updatedTime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        Intent intent = getIntent();
        updatedTime = findViewById(R.id.updatedTime);
        String time = intent.getStringExtra("time");
        updatedTime.setText(time);
        regionalList = new ArrayList<>();
        contactRecyclerView = findViewById(R.id.contactsRecyclerView);
        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mainActivityViewModel.getCompleteContactsApi();
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mainActivityViewModel.getContacts().observe(this, new Observer<Contacts>() {
            @Override
            public void onChanged(Contacts contacts) {
                Data data = contacts.getData();
                Contacts_ contacts_ = data.getContacts();
                List<Regional> regionals = contacts_.getRegional();
                regionalList = regionals;
                contactRecyclerView.setLayoutManager(new LinearLayoutManager(ContactsActivity.this));
                ContactsRecyclerViewAdapter contactsRecyclerViewAdapter = new ContactsRecyclerViewAdapter(ContactsActivity.this,regionalList);
                contactRecyclerView.setAdapter(contactsRecyclerViewAdapter);
            }
        });


    }
}
