package com.example.transectionapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TransactionAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private ArrayList<TransactionParticipantModel> mDataList;
    private View.OnClickListener listener;


    public TransactionAdapter(Context mContext, ArrayList<TransactionParticipantModel> mDataList, View.OnClickListener listener) {
        this.mContext = mContext;
        this.mDataList = mDataList;
        this.listener=listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View entryView = LayoutInflater.from(mContext).inflate(R.layout.layout_item_transaction_entry,viewGroup,false);
        return new TransactionVH(entryView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        TransactionVH transactionVH = (TransactionVH) viewHolder;
        transactionVH.name.setText(mDataList.get(i).getName());
        transactionVH.remove.setTag(i);

    }

    @Override
    public int getItemCount() {
        if (mDataList==null){
            return 0;
        }
        return mDataList.size();
    }
    class TransactionVH extends RecyclerView.ViewHolder {
        TextView name;
        ImageView remove;
        EditText paid;
        EditText share;
        public TransactionVH(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            remove = itemView.findViewById(R.id.close);
            paid = itemView.findViewById(R.id.paid);
            share = itemView.findViewById(R.id.share);
            remove.setOnClickListener(listener);
            paid.addTextChangedListener(new TransectionActivity.CustomTextWatcher(paid));
            share.addTextChangedListener(new TransectionActivity.CustomTextWatcher(share));
        }
    }
}
