package com.example.transectionapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContactListAdapter extends RecyclerView.Adapter {
    private String[] names;
    private Context mContext;
    private View.OnClickListener listener;

    public ContactListAdapter(String[] names, Context mContext, View.OnClickListener listener) {
        this.names = names;
        this.mContext = mContext;
        this.listener= listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View contactInflatedView = LayoutInflater.from(mContext).inflate(R.layout.layout_item_contact,viewGroup,false);
        return new ContactVH(contactInflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
            ContactVH contactVH = (ContactVH) viewHolder;
            contactVH.contactName.setText(names[position]);
            contactVH.contactName.setTag(names[position]);
    }

    @Override
    public int getItemCount() {
        if (names==null){
            return 0;
        }
        return names.length;
    }

    class ContactVH extends RecyclerView.ViewHolder{
        TextView contactName;
        public ContactVH(@NonNull View itemView) {
            super(itemView);
            contactName = itemView.findViewById(R.id.contact_name);
            contactName.setOnClickListener(listener);
        }
    }

}
