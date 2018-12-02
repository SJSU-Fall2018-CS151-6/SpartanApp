package com.wolfsoft.one.bronzeapp.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.wolfsoft.one.bronzeapp.R;

import java.util.ArrayList;

public class LectureSelector extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_selector);

        ListView listView = (ListView) findViewById(R.id.listAvailableLectures);

        AvailableCourses courses = new AvailableCourses(this);

        final ArrayList<Lecture> list = courses.getLectures();

        ScheduleListAdapter adapter = new ScheduleListAdapter(list,this);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent resultIntent = new Intent();

                resultIntent.putExtra("lectureIndex", Integer.toString(i));
                setResult(i, resultIntent);
                finish();
            }
        });

    }

    public void goBack(View v){
        finish();
    }

}
