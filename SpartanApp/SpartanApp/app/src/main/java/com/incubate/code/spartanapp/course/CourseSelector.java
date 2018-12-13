
package com.incubate.code.spartanapp.course;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.incubate.code.spartanapp.R;

import java.util.ArrayList;

/**
 * The screen for seling classes to fit into your schedule
 */

public class CourseSelector extends AppCompatActivity {

    /**
     * setting up the Screen
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture_selector);

        ListView listView = (ListView) findViewById(R.id.listAvailableLectures);

        AvailableCourses courses = new AvailableCourses(this);

        final ArrayList<Course> list = courses.getCourses();

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

    /**
     * Implementing the interface to have a wy to go to the homescreen
     * @param v the calling view
     */
    public void goBack(View v){
        finish();
    }

}
