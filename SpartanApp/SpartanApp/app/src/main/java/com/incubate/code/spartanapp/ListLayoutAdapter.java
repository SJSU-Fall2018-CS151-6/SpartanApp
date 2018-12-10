//package com.wolfsoft.one.bronzeapp;
package com.incubate.code.spartanapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by zero on 6/11/15.
 */
public class ListLayoutAdapter extends BaseAdapter {


    private Context context;
    private ArrayList<List> listPojo;


    public ListLayoutAdapter(Context context, ArrayList<List> listPojo) {
        this.context = context;
        this.listPojo = listPojo;
    }

    @Override
    public int getCount() {
        return listPojo.size();
    }

    @Override
    public Object getItem(int i) {
        return listPojo.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        MyViewHolder holder = null;
        final int pos = i;

        if (view == null) {

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.list_listview, null);

            holder = new MyViewHolder();


            holder.title = (TextView) view.findViewById(R.id.title);
            holder.correct = (ImageView) view.findViewById(R.id.correct);
            holder.linear = (LinearLayout)view.findViewById(R.id.linear);
            holder.leftVerticleLine  = (LinearLayout)view.findViewById(R.id.leftVerticleLine);


            // At here set animation by their position.. Means if position = 0.. then animation start on textview with i*50 = 0 startOffset


            view.setTag(holder);

        } else {

            holder = (MyViewHolder) view.getTag();
        }

        List rowItem = (List) getItem(i);

        holder.title.setText(rowItem.getTitle());

        if (rowItem.isHasRight() == true){
            holder.correct.setColorFilter(Color.parseColor("#3bbfaf"));
            holder.linear.setBackgroundColor(Color.parseColor("#f8f8fa"));
            holder.title.setTextColor(Color.parseColor("#515b6e"));
            holder.leftVerticleLine.setBackgroundColor(Color.parseColor("#3bbfaf"));
        }else {
            holder.correct.setColorFilter(Color.parseColor("#bbbbbd"));
            holder.linear.setBackgroundColor(Color.parseColor("#ffffff"));
            holder.title.setTextColor(Color.parseColor("#111111"));
            holder.leftVerticleLine.setBackgroundColor(Color.parseColor("#ffffff"));

        }


        return view;
    }


    class MyViewHolder {

        private TextView title;
        private ImageView correct;
        private LinearLayout linear;
        private LinearLayout leftVerticleLine;

    }




    @Override
    public int getViewTypeCount() {

        return getCount();
    }
    //
    @Override
    public int getItemViewType(int position) {

        return position;
    }
}
