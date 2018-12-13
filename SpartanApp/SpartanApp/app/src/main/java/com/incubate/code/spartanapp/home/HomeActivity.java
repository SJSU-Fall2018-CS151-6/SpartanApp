//package com.wolfsoft.one.bronzeapp.home;
package com.incubate.code.spartanapp.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.incubate.code.spartanapp.EventActivity;
import com.incubate.code.spartanapp.GraphActivity;
import com.incubate.code.spartanapp.GridLayoutActivity;
import com.incubate.code.spartanapp.ListOfAllAppActivity;
import com.incubate.code.spartanapp.NavigationActivity;
import com.incubate.code.spartanapp.PieGraphActivity;
import com.incubate.code.spartanapp.R;
import com.incubate.code.spartanapp.SettingsActivity;
import com.incubate.code.spartanapp.course.CourseSchedule;
import com.incubate.code.spartanapp.todo.ToDoActivity;

/**
 * Management activity
 * for going to every other screen
 */

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

    }


    public void gotToSchedule(View v){
        Intent intent = new Intent(getApplicationContext(), CourseSchedule.class);

        startActivity(intent);
    }

    public void gotToList(View v){
        Intent intent = new Intent(getApplicationContext(), ListOfAllAppActivity.class);

        startActivity(intent);
    }

    public void gotToSettings(View v){
        Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);

        startActivity(intent);
    }

    public void gotToProfile(View v){
        Intent intent = new Intent(getApplicationContext(), GridLayoutActivity.class);

        startActivity(intent);
    }

    public void gotToChart(View v){
        Intent intent = new Intent(getApplicationContext(), PieGraphActivity.class);

        startActivity(intent);
    }

    public void gotToEvent(View v){
        Intent intent = new Intent(getApplicationContext(), EventActivity.class);

        startActivity(intent);
    }

    public void gotToCalc(View v){
        Intent intent = new Intent(getApplicationContext(), GraphActivity.class);

        startActivity(intent);
    }

    public void logOut(View v){
        finish();
    }

    public void goToToDo(View v){
        Intent intent = new Intent(getApplicationContext(), ToDoActivity.class);

        startActivity(intent);
    }
}
