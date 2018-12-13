//package com.wolfsoft.one.bronzeapp;
package com.incubate.code.spartanapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.txusballesteros.widgets.FitChart;
import com.txusballesteros.widgets.FitChartValue;

import java.util.ArrayList;
import java.util.Collection;

//import com.wolfsoft.one.spartanapp.R;

public class PieGraphActivity extends AppCompatActivity {

    private FitChart big;
    private FitChart small2;
    private FitChart small1;

    private ListView list;
    private GraphListLayoutAdapter graphListLayoutAdapter;


    int value1, value2,value3;

    private String[] TITLE = {"Homework","Lab","Quizzes","Midterms","Projects","Assays","Finals"};
    private String[] SUB_TITLE = {"25","12","8","56","6","33","11"};
    private String[] COLORS = {"#FF4081","#4cd2c7","#8284ab","#d7dafd","#faa75b","#f2c2ec","#ff527d","#4cd2c7"};

    private ArrayList<GraphList> graphListArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_graph);

        list = (ListView)findViewById(R.id.list);


        graphListArrayList = new ArrayList<GraphList>();

        for (int i=0; i<TITLE.length; i++){

            GraphList graphList = new GraphList(TITLE[i], SUB_TITLE[i], COLORS[i]);
            graphListArrayList.add(graphList);

        }


        list = (ListView) findViewById(R.id.list);
        graphListLayoutAdapter = new GraphListLayoutAdapter(PieGraphActivity.this, graphListArrayList);
        list.setAdapter(graphListLayoutAdapter);

        big = (FitChart)findViewById(R.id.big);
        small2 = (FitChart)findViewById(R.id.small2);
        small1 = (FitChart)findViewById(R.id.small1);


        big.setMinValue(0);
        big.setMaxValue(100);

        small1.setMinValue(0);
        small1.setMaxValue(100);

        small2.setMinValue(0);
        small2.setMaxValue(100);

        value1 = 74;
        value2 = 40;
        value3 = 74;


        Collection<FitChartValue> valuesBig = new ArrayList<>();
        valuesBig.add(new FitChartValue(value1, Color.parseColor("#2979FF")));

        Collection<FitChartValue> valuesSmall1 = new ArrayList<>();
        valuesSmall1.add(new FitChartValue(value2, Color.parseColor("#2979FF")));

        Collection<FitChartValue> valuesSmall2 = new ArrayList<>();
        valuesSmall2.add(new FitChartValue(value3, Color.parseColor("#2979FF")));

        big.setValues(valuesBig);
        small1.setValues(valuesSmall1);
        small2.setValues(valuesSmall2);
    }
}
