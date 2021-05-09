package com.example.vaccinenotifier;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CenterListAdapter extends RecyclerView.Adapter<CenterListAdapter.ViewHolder>{

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView name;
        public TextView availability;
        public TextView vaccine;
        public TextView date;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.center_name);
            availability = (TextView) itemView.findViewById(R.id.availability);
            vaccine = (TextView) itemView.findViewById(R.id.vaccine);
            date = (TextView) itemView.findViewById(R.id.date);
        }
    }

    private List<CenterModel> sessionList;
    // Pass in the contact array into the constructor
    public CenterListAdapter(List<CenterModel> contacts) {
        sessionList = contacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_center, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CenterModel session = sessionList.get(position);

        // Set item views based on your views and data model
        holder.name.setText(session.getName());
        System.out.println(session.getAvailable_capacity());
        holder.availability.setText(String.valueOf(session.getAvailable_capacity()));
        holder.vaccine.setText(session.getVaccine());
        holder.date.setText(session.getDate());

    }

    @Override
    public int getItemCount() {
        return sessionList.size();
    }
}
