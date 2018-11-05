package com.wolfsoft.one.bronzeapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

public class GridLayoutActivity extends AppCompatActivity {

    private GridView gridList;
    private GridLayoutAdapter gridLayoutAdapter;
    private ArrayList<BeanClassGrid> beanClassGridArrayList;

    private String[] TITLE = {"Shop","Work","Health","Travel","Bills","Auto","Shop","Work"};
    private String[] SUB_TITLE = {"25 ITEMS","12 ITEMS","8 ITEMS","56 ITEMS","6 ITEMS","33 ITEMS","11 ITEMS","6 ITEMS"};
    private String[] COLORS = {"#FF4081","#4cd2c7","#8284ab","#d7dafd","#faa75b","#f2c2ec","#ff527d","#4cd2c7","#8284ab"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);


        beanClassGridArrayList = new ArrayList<BeanClassGrid>();

        for (int i=0; i<TITLE.length; i++){

            BeanClassGrid beanClassGrid = new BeanClassGrid(TITLE[i], SUB_TITLE[i], COLORS[i]);
            beanClassGridArrayList.add(beanClassGrid);

        }


        gridList = (GridView)findViewById(R.id.gridList);
        gridLayoutAdapter = new GridLayoutAdapter(GridLayoutActivity.this, beanClassGridArrayList);
        gridList.setAdapter(gridLayoutAdapter);

    }
}
