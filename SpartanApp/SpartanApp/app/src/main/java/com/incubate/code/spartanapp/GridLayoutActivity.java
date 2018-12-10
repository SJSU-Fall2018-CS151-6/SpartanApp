//package com.wolfsoft.one.bronzeapp;
package com.incubate.code.spartanapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

public class GridLayoutActivity extends AppCompatActivity {

    private GridView gridList;
    private GridLayoutAdapter gridLayoutAdapter;
    private ArrayList<BeanClassGrid> beanClassGridArrayList;

    private String[] TITLE = {"Homework","Lab","Quizzes","Midterms","Projects","Finals"};
    private String[] SUB_TITLE = {"25 ITEMS","12 ITEMS","8 ITEMS","56 ITEMS","6 ITEMS","33 ITEMS"};
    private String[] COLORS = {"#FF4081","#4cd2c7","#8284ab","#d7dafd","#faa75b","#f2c2ec","#ff527d"};

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
