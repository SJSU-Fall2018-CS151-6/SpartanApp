//package com.wolfsoft.one.bronzeapp;
package com.incubate.code.spartanapp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

//import com.wolfsoft.one.spartanapp.R;

/**
 * Created by zero on 6/11/15.
 */
public class GridLayoutAdapter extends BaseAdapter {


    private Context context;
    private ArrayList<BeanClassGrid> listPojo;


    public GridLayoutAdapter(Context context, ArrayList<BeanClassGrid> listPojo) {
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

            view = inflater.inflate(R.layout.list_grid, null);

            holder = new MyViewHolder();


            holder.title = (TextView) view.findViewById(R.id.title);
            holder.sub = (TextView) view.findViewById(R.id.sub);
            holder.line = (LinearLayout) view.findViewById(R.id.line);


            // At here set animation by their position.. Means if position = 0.. then animation start on textview with i*50 = 0 startOffset


            view.setTag(holder);

        } else {

            holder = (MyViewHolder) view.getTag();
        }

        BeanClassGrid rowItem = (BeanClassGrid) getItem(i);

        holder.title.setText(rowItem.getTitle());
        holder.sub.setText(rowItem.getSubTitle());
        holder.line.setBackgroundColor(Color.parseColor(rowItem.getColorCode()));


        return view;
    }


    class MyViewHolder {

        private TextView title;
        private TextView sub;
        private LinearLayout line;
        private TextView sem;

    }

}
