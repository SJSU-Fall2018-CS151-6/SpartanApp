package com.wolfsoft.one.bronzeapp.calendar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wolfsoft.one.bronzeapp.R;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

public class ScheduleListAdapter extends ArrayAdapter<Lecture> implements View.OnClickListener{

        private ArrayList<Lecture> dataSet;
        Context mContext;

        // View lookup cache
        private static class ViewHolder {
            TextView textViewName;
            TextView textViewTime;
            ImageView imageView;
        }

        public ScheduleListAdapter(ArrayList<Lecture> data, Context context) {
            super(context, R.layout.schedule_item, data);
            this.dataSet = data;
            this.mContext=context;

        }

        @Override
        public void onClick(View v) {

            int position = (Integer) v.getTag();
            Object object = getItem(position);
            Lecture dataModel = (Lecture) object;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Get the data item for this position
            Lecture lecture = getItem(position);

            // Check if an existing view is being reused, otherwise inflate the view
            ViewHolder viewHolder = new ViewHolder();; // view lookup cache stored in tag


            Drawable myIcon = getContext().getResources().getDrawable(R.drawable.tomcruise);

            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.schedule_item, parent, false);

            }

            viewHolder.textViewName = (TextView) convertView.findViewById(R.id.lectureName);
            viewHolder.textViewTime = (TextView) convertView.findViewById(R.id.lectureTime);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.lectureImage);

            convertView.setTag(viewHolder);

            Log.e("adapter", lecture.name);
            viewHolder.textViewName.setText(lecture.name);
            viewHolder.textViewTime.setText("heute");
            viewHolder.imageView.setImageDrawable(myIcon);

            return convertView;
        }
}
