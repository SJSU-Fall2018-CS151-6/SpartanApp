//package com.wolfsoft.one.bronzeapp;
package com.incubate.code.spartanapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;

import com.github.mikephil.charting.charts.BarChart;
import com.incubate.code.spartanapp.login.Credentials;
import com.incubate.code.spartanapp.stackedchart.StackedCardOne;
import com.rey.material.widget.TextView;

import java.util.ArrayList;

import customfonts.MyTextView;

//import com.wolfsoft.one.spartanapp.R;

//import com.wolfsoft.one.bronzeapp.stackedchart.StackedCardOne;

public class GraphActivity extends AppCompatActivity {

    private BarChart chart;

   // private android.support.v4.app.Fragment mCurrFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_graph);

        MyTextView textView = (MyTextView) findViewById(R.id.barUserNameLable);

        textView.setText(Credentials.getUserName());

        (new StackedCardOne((CardView) findViewById(R.id.card5))).init();

//        mCurrFragment = new ChartsFragment();
//        getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.container, mCurrFragment)
//                .commit();



//        chart = (BarChart) findViewById(R.id.chart);
//
//
//        BarData data = new BarData(getXAxisValues(), getDataSet());
//        chart.setData(data);
//        chart.setDescription("");    // Hide the description
//        chart.getAxisLeft().setDrawLabels(false);
//        chart.getAxisRight().setDrawLabels(false);
//        chart.setScaleXEnabled(false);
//        chart.getLegend().setEnabled(false); // your data value willl be hide
//        chart.getAxisLeft().setDrawGridLines(false);
//        chart.getXAxis().setDrawGridLines(false);  // Grid lines disable
//        chart.getAxisLeft().setDrawAxisLine(false);
//        chart.getAxisRight().setDrawGridLines(false);
//        chart.setDrawValueAboveBar(true);
//        chart.getAxisRight().setGridColor(Color.parseColor("#d8d8d8"));
//        chart.animateXY(2000, 2000);
//        chart.invalidate();
//
//
//
//        Paint p1 = chart.getPaint(Chart.PAINT_GRID_BACKGROUND);
//        p1.setColor(Color.TRANSPARENT);
//
//        XAxis xAxis = chart.getXAxis();
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        // x axis values display at bottom
//        xAxis.setTextColor(Color.parseColor("#8e979e"));
//
//        xAxis = chart.getXAxis();
//        xAxis.setDrawAxisLine(false); // Hide x axis line
//
//
//        YAxis yl = chart.getAxisRight();
//        yl.setDrawAxisLine(false);
//        yl.setTextColor(Color.parseColor("#8e979e"));
//
//        chart.setTouchEnabled(false); // Touch become disable
//    }
//
//
//
//    private ArrayList<BarDataSet> getDataSet() {
//        ArrayList<BarDataSet> dataSets = null;
//
//
//        // this data set at y axis as par x axis position
//        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
//
////
////        BarEntry v1e10 = new BarEntry(04.58f, 9); // 6
////        valueSet1.add(v1e10);
//
//        BarEntry v1e9 = new BarEntry(03.78f, 8); // 5
//        valueSet1.add(v1e9);
//
//        BarEntry v1e8 = new BarEntry(07.34f, 7); // 4
//        valueSet1.add(v1e8);
//
//
//        BarEntry v1e7 = new BarEntry(08.58f, 6); // 6
//        valueSet1.add(v1e7);
//
//        BarEntry v1e6 = new BarEntry(01.78f, 5); // 5
//        valueSet1.add(v1e6);
//
//        BarEntry v1e0 = new BarEntry(06.34f, 4); // 4
//        valueSet1.add(v1e0);
//
//        BarEntry v1e2 = new BarEntry(00.59f, 3); // 3
//        valueSet1.add(v1e2);
//        BarEntry v1e3 = new BarEntry(03.45f, 2); // 2
//        valueSet1.add(v1e3);
//        BarEntry v1e4 = new BarEntry(04.34f, 1); // 1
//        valueSet1.add(v1e4);
//        BarEntry v1e5 = new BarEntry(01.18f, 0); // 0
//        valueSet1.add(v1e5);
//
//
//
//        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Brand 1");
//        barDataSet1.setValueTextColor(Color.parseColor("#f46b61"));
//        barDataSet1.setValueTextSize(10f);
//        barDataSet1.setDrawValues(false);
//
//
//        barDataSet1.setColors(ColorTemplate.LIBERTY_COLORS);
//
//        // set the space between your bar as per percentage
//        barDataSet1.setBarSpacePercent(70);
//
//        dataSets = new ArrayList<>();
//        dataSets.add(barDataSet1);
//
//
//        return dataSets;

    }


    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();

        xAxis.add("1");
        xAxis.add("3");
        xAxis.add("6");
        xAxis.add("9");
        xAxis.add("12");
        xAxis.add("15");
        xAxis.add("18");
        xAxis.add("21");
        xAxis.add("24");


        return xAxis;
    }




}
