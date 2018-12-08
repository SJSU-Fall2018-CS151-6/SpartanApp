package com.incubate.code.spartanapp.course;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.incubate.code.spartanapp.R;
import java.util.ArrayList;

/**
 * This method will handel all the necessary activities for listing
 * course schedule also extends ArrayAdapter<Course>
 *
 */

public class ScheduleListAdapter extends ArrayAdapter<Course> implements View.OnClickListener{

        private ArrayList<Course> dataSet;
        Context mContext;

        // View lookup cache
        private static class ViewHolder {
            TextView textViewName;
            TextView textViewTime;
            TextView textViewRoom;
            TextView textViewTeacher;

            ImageView imageView;
        }

    /**
     *
     * @param data
     * @param context
     */
    public ScheduleListAdapter(ArrayList<Course> data, Context context) {
            super(context, R.layout.schedule_item, data);
            this.dataSet = data;
            this.mContext=context;

        }

    /**
     *
      * @param v
     */
    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        Course dataModel = (Course) object;
    }

    /**
     *
     * @param position
     * @param convertView
     * @param parent
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Course course = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder = new ViewHolder();; // view lookup cache stored in tag

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.schedule_item, parent, false);

        }

        viewHolder.textViewName = (TextView) convertView.findViewById(R.id.lectureName);
        viewHolder.textViewTime = (TextView) convertView.findViewById(R.id.lectureTime);
        viewHolder.textViewRoom = (TextView) convertView.findViewById(R.id.lectureRoom);
        viewHolder.textViewTeacher = (TextView) convertView.findViewById(R.id.lectureTeacher);
        viewHolder.imageView = (ImageView) convertView.findViewById(R.id.lectureImage);

        convertView.setTag(viewHolder);

        Log.e("adapter", course.getCourseName());
        viewHolder.textViewName.setText(course.getCourseName());
        viewHolder.textViewTime.setText(course.getCourseTime());
        viewHolder.textViewRoom.setText(course.getClassRoom());
        viewHolder.textViewTeacher.setText(course.getTeacherName());
        viewHolder.imageView.setImageDrawable(course.getCourseImage());

        return convertView;
    }
}
