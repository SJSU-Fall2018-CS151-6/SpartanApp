//package com.wolfsoft.one.bronzeapp.course;
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
 * This class is for connecting an arraylist of courses with the actual list
 */

public class ScheduleListAdapter extends ArrayAdapter<Course> implements View.OnClickListener{

        private ArrayList<Course> dataSet;
        Context mContext;

    /**
     *  This is a class that defines all the views for one row
     */
    // View lookup cache
    private static class ViewHolder {
        TextView textViewName;
        TextView textViewTime;
        TextView textViewRoom;
        TextView textViewTeacher;

        ImageView imageView;
    }

    /**
     * Construncter
     *
     * @param data is the courses list to assign
     * @param context
     */

    public ScheduleListAdapter(ArrayList<Course> data, Context context) {
            super(context, R.layout.schedule_item, data);
            this.dataSet = data;
            this.mContext=context;

    }

    /**
     * for taking an action, when someone is pressing an element of the list
     * @param v the calling view
     */
    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        Course dataModel = (Course) object;
    }

    /**
     * for the settup of the rows
     *
     * @param position
     * @param convertView
     * @param parent
     * @return the view of each row
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

        Log.e("adapter", course.getName());
        viewHolder.textViewName.setText(course.getName());
        viewHolder.textViewTime.setText(course.getTime());
        viewHolder.textViewRoom.setText(course.getRoom());
        viewHolder.textViewTeacher.setText(course.getTeacherName());
        viewHolder.imageView.setImageDrawable(course.getImage());

        return convertView;
    }
}
