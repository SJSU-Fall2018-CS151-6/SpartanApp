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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Activity to show all the courses you are taking
 */

public class CourseSchedule extends AppCompatActivity implements Behavior {

    ArrayList<Course> list = new ArrayList<>();
    ListView listView;
    ScheduleListAdapter adapter;

    /**
     * creating the view
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_calender);

        adapter = new ScheduleListAdapter(list, this);

        listView = (ListView) findViewById(R.id.scheduleListView);


        listView.setAdapter(adapter);
    }

    /**
     * for the button in the bottom right corner, when it is been pressed
     * @param v the calling view
     */
    public void addNewCourse(View v){

        Intent intent = new Intent(getApplicationContext(), CourseSelector.class);

        startActivityForResult(intent, 11);

    }

    /**
     * For receiving the choice that has been made at the CourseSelector Activity
     *
     */

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (11) : {
                if(data != null ){
                    String returnValue = data.getStringExtra("lectureIndex");

                    AvailableCourses courses = new AvailableCourses(this);

                    try {
                        Class<?> c = Class.forName("com.incubate.code.spartanapp.course.AvailableCourses");

                        Class[] type = { CourseSchedule.class };
                        Constructor constructor = c.getConstructor(type);
                        courses = (AvailableCourses) constructor.newInstance(this);

                        // production code should handle these exceptions more gracefully
                    } catch (InstantiationException ie){
                        ie.printStackTrace();
                    } catch (ClassNotFoundException cnfe){
                        cnfe.printStackTrace();
                    }catch (NoSuchMethodException nsme){
                        nsme.printStackTrace();
                    }catch (IllegalAccessException iae){
                        iae.printStackTrace();
                    }catch (InvocationTargetException ite){
                        ite.printStackTrace();
                    }

                    Course course = courses.getIndexOf(Integer.parseInt(returnValue));
                    adapter.add(course);
                    adapter.notifyDataSetChanged();
                }

                break;
            }
        }
    }

    /**
     * Implementing the interface to have a wy to go to the homescreen
     * @param v the calling view
     */

    @Override
    public void goHome(View v) {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);

        startActivity(intent);
    }
}
