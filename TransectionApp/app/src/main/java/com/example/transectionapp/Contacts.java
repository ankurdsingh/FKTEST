package com.example.transectionapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import static com.example.transectionapp.Utility.CONTACT_EXTRA_RESULT_DATA;

public class Contacts extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        RecyclerView contactList = findViewById(R.id.contact_list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Contacts.this);
        ContactListAdapter contactListAdapter = new ContactListAdapter(getResources().getStringArray(R.array.contacts),Contacts.this,this);
        contactList.setLayoutManager(layoutManager);
        contactList.setAdapter(contactListAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.contact_name:
                Intent intent = new Intent();
                intent.putExtra(CONTACT_EXTRA_RESULT_DATA,(String) v.getTag());
                setResult(RESULT_OK,intent);
                finish();
                break;
        }
    }
}
