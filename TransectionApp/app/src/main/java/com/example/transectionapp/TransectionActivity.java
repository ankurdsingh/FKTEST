package com.example.transectionapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import static com.example.transectionapp.Utility.CONTACT_ADD_REQUEST_CODE;
import static com.example.transectionapp.Utility.CONTACT_EXTRA_RESULT_DATA;

public class TransectionActivity extends AppCompatActivity implements View.OnClickListener {
    private Button addParticipient;
    private Button add;
    private EditText transectionDetails;
    private EditText transectionAmount;
    private RecyclerView tarnsactionEntry;
    private TransactionAdapter transactionAdapter;
    private ArrayList<TransactionParticipantModel> mDataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transection);
        mDataList = new ArrayList<>();
        addParticipient = findViewById(R.id.add_participant);
        addParticipient.setOnClickListener(this);
        add = findViewById(R.id.add_transaction);
        tarnsactionEntry = findViewById(R.id.transaction_add_view);
        transactionAdapter = new TransactionAdapter(TransectionActivity.this,mDataList,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(TransectionActivity.this);
        tarnsactionEntry.setLayoutManager(layoutManager);
        tarnsactionEntry.setAdapter(transactionAdapter);
        transectionDetails = findViewById(R.id.transection_details);
        transectionDetails.addTextChangedListener(new CustomTextWatcher(transectionDetails));
        transectionAmount = findViewById(R.id.transaction_amount);
        transectionAmount.addTextChangedListener(new CustomTextWatcher(transectionDetails));


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_participant:
                startActivityForResult(new Intent(TransectionActivity.this,Contacts.class),CONTACT_ADD_REQUEST_CODE,null);
                break;
            case R.id.add_transaction:
                break;
            case R.id.close:
                if (v.getTag()!=null) {
                    int position = (int) v.getTag();
                    mDataList.remove(position);
                    transactionAdapter.notifyItemRemoved(position);
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CONTACT_ADD_REQUEST_CODE && resultCode== Contacts.RESULT_OK && data!=null){
            final TransactionParticipantModel model = new TransactionParticipantModel();
            model.setName(data.getStringExtra(CONTACT_EXTRA_RESULT_DATA));
            mDataList.add(model);
            transactionAdapter.notifyDataSetChanged();
        }
    }

    public static class CustomTextWatcher implements TextWatcher{
        View view;

        public CustomTextWatcher(View view) {
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            switch (view.getId()){
                case R.id.transection_details:
                    break;
                case R.id.transaction_amount:
                    break;
                case R.id.paid:
                    break;
                case R.id.share:
                    break;
            }
        }
    }
}
