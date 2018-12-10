//package com.wolfsoft.one.bronzeapp;
package com.incubate.code.spartanapp;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class AllAppListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<AllAppList> listPojo;

    public AllAppListAdapter(Context context, ArrayList<AllAppList> listPojo) {
        super();
        this.context = context;
        this.listPojo = listPojo;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listPojo.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return listPojo.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        MyViewHolder holder = null;

        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(
                    R.layout.list_all_app, null);

            holder = new MyViewHolder();

            holder.title = (TextView) convertView
                    .findViewById(R.id.title);





            // At here set animation by their position.. Means if position = 0.. then animation start on textview with i*50 = 0 startOffset

            convertView.setTag(holder);

        } else {

            holder = (MyViewHolder) convertView.getTag();
        }

        AllAppList rowItem = (AllAppList) getItem(position);
        holder.title.setText(rowItem.getName());






        return convertView;
    }

    class MyViewHolder {


        private TextView title;



    }


}
