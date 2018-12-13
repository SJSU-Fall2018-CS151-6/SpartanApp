package com.incubate.code.spartanapp.todo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.incubate.code.spartanapp.R;
import java.util.ArrayList;

/**
 * this class defines how to connect an ArrayList of Assignments to an ListView(RecyclerView)
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private ArrayList<Assignment> data;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitle;

        public MyViewHolder(View itemView) {
            super(itemView);

            mTitle = (TextView) itemView.findViewById(R.id.txtTitle);

        }
    }

    /**
     * Constructor
     * @param data is a list of Assignments
     */
    public RecyclerViewAdapter(ArrayList<Assignment> data) {
        this.data = data;
    }

    /**
     * creating each item of the list
     * @return the set up of the rowView
     */
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_row, parent, false);
        itemView.setOnClickListener(new AssignmentDetails(parent.getContext()));
        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        String assignmentName = data.get(position).getName();
        holder.mTitle.setText(assignmentName);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public void removeItem(int position) {
        data.remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(Assignment item, int position) {
        data.add(position, item);
        notifyItemInserted(position);
    }

    public void changeItem(Assignment item, int position) {
        data.set(position, item);
        notifyItemChanged(position);
    }

    public ArrayList<Assignment> getData() {
        return data;
    }
}



