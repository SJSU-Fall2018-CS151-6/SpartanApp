package com.wolfsoft.one.bronzeapp.course;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.wolfsoft.one.bronzeapp.R;
import com.wolfsoft.one.bronzeapp.login.Credentials;

import java.io.Serializable;
import java.util.ArrayList;

public class CourseSchedule extends AppCompatActivity implements Serializable {

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

        TextView textView = (TextView) findViewById(R.id.userName);

        textView.setText(Credentials.getUserName());
    }

    public void addNewLecture(View v){

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

    public void logOut(View v){
        finish();
    }
}
