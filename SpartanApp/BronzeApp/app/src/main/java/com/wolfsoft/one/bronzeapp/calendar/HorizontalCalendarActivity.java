package com.wolfsoft.one.bronzeapp.calendar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.wolfsoft.one.bronzeapp.R;
import com.wolfsoft.one.bronzeapp.login.SignUpActivity;

import java.util.ArrayList;

public class HorizontalCalendarActivity extends AppCompatActivity {

    ArrayList<Lecture> list = new ArrayList<>();
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

    public void addNewLecture(View v){

        Intent intent = new Intent(getApplicationContext(), LectureSelector.class);

        startActivityForResult(intent, 11);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode) {
            case (11) : {
                if(data != null ){
                    String returnValue = data.getStringExtra("lecture");
                    Toast.makeText(getApplicationContext(), returnValue, Toast.LENGTH_LONG).show();
                    Lecture lecture = new Lecture();
                    lecture.name = returnValue;
                    adapter.add(lecture);
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
