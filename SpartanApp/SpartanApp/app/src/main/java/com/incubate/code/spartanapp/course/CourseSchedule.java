//package com.wolfsoft.one.bronzeapp.course;
package com.incubate.code.spartanapp.course;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.incubate.code.spartanapp.R;
import com.incubate.code.spartanapp.general.Behavior;
import com.incubate.code.spartanapp.home.HomeActivity;

import java.util.ArrayList;

public class CourseSchedule extends AppCompatActivity implements Behavior {

    ArrayList<Course> list = new ArrayList<>();
    ListView listView;
    ScheduleListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_calender);

        adapter = new ScheduleListAdapter(list, this);

        listView = (ListView) findViewById(R.id.scheduleListView);

        listView.setAdapter(adapter);
    }

    public void addNewCourse(View v){

        Intent intent = new Intent(getApplicationContext(), CourseSelector.class);

        startActivityForResult(intent, 11);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (11) : {
                if(data != null ){
                    String returnValue = data.getStringExtra("lectureIndex");

                    AvailableCourses courses = new AvailableCourses(this);
                    Course course = courses.getIndexOf(Integer.parseInt(returnValue));
                    adapter.add(course);
                    adapter.notifyDataSetChanged();
                }

                break;
            }
        }
    }

    @Override
    public void goHome(View v) {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);

        startActivity(intent);
    }
}