//package com.wolfsoft.one.bronzeapp;
package com.incubate.code.spartanapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.incubate.code.spartanapp.course.CourseSchedule;
import com.incubate.code.spartanapp.login.LoginActivity;
import com.incubate.code.spartanapp.login.SignUpActivity;

import java.util.ArrayList;

public class ListOfAllAppActivity extends AppCompatActivity {

    private ListView list;
    private AllAppListAdapter allAppListAdapter;

    private String[] TITLES = {"Login", "Sign up", "Settings", "Pie Chart", "Bar Graph", "Horizontal Calendar",
            "Calendar View", "View Pager", "List Layout","Grid Layout","Navigation","Sticky ListView"};


    private ArrayList<AllAppList> allAppListArrayList;


    // f8f8f9

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_all_app);


        list = (ListView)findViewById(R.id.list);

        allAppListArrayList = new ArrayList<AllAppList>();

        for (int i=0; i<TITLES.length; i++){

            AllAppList list = new AllAppList(TITLES[i]);


            allAppListArrayList.add(list);

        }

        allAppListAdapter = new AllAppListAdapter(ListOfAllAppActivity.this, allAppListArrayList);
        list.setAdapter(allAppListAdapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                selectItemClick(position);

            }
        });




    }


    private void selectItemClick(int position){


        Intent it;

        switch (position){


            case 0 :

                 it = new Intent(ListOfAllAppActivity.this, LoginActivity.class);
                startActivity(it);

                break;


            case 1 :

                it = new Intent(ListOfAllAppActivity.this, SignUpActivity.class);
                startActivity(it);

                break;

            case 2 :

                it = new Intent(ListOfAllAppActivity.this, SettingsActivity.class);
                startActivity(it);


                break;

            case 3 :

                it = new Intent(ListOfAllAppActivity.this, PieGraphActivity.class);
                startActivity(it);


                break;

            case 4 :

                it = new Intent(ListOfAllAppActivity.this, GraphActivity.class);
                startActivity(it);


                break;

            case 5 :

                it = new Intent(ListOfAllAppActivity.this, CourseSchedule.class);
                startActivity(it);


                break;

            case 6 :

                it = new Intent(ListOfAllAppActivity.this, BigCalendarActivity.class);
                startActivity(it);

                break;

            case 7 :

                it = new Intent(ListOfAllAppActivity.this, ViewPagerActivity.class);
                startActivity(it);

                break;


            case 8 :

                it = new Intent(ListOfAllAppActivity.this, ListActivity.class);
                startActivity(it);

                break;


            case 9 :

                it = new Intent(ListOfAllAppActivity.this, GridLayoutActivity.class);
                startActivity(it);

                break;


            case 10 :

                it = new Intent(ListOfAllAppActivity.this, NavigationActivity.class);
                startActivity(it);

                break;


            case 11 :

                it = new Intent(ListOfAllAppActivity.this, StikListviewActtitvity.class);
                startActivity(it);

                break;

        }


    }
}
