package com.wolfsoft.one.bronzeapp.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.wolfsoft.one.bronzeapp.AllAppList;
import com.wolfsoft.one.bronzeapp.GraphActivity;
import com.wolfsoft.one.bronzeapp.GridLayoutActivity;
import com.wolfsoft.one.bronzeapp.ListOfAllAppActivity;
import com.wolfsoft.one.bronzeapp.NavigationActivity;
import com.wolfsoft.one.bronzeapp.PieGraphActivity;
import com.wolfsoft.one.bronzeapp.R;
import com.wolfsoft.one.bronzeapp.SettingsActivity;
import com.wolfsoft.one.bronzeapp.course.CourseSchedule;
import com.wolfsoft.one.bronzeapp.login.SignUpActivity;

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
        Intent intent = new Intent(getApplicationContext(), NavigationActivity.class);

        startActivity(intent);
    }

    public void gotToCalc(View v){
        Intent intent = new Intent(getApplicationContext(), GraphActivity.class);

        startActivity(intent);
    }

    public void logOut(View v){
        finish();
    }
}
