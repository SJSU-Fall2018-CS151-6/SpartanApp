//package com.wolfsoft.one.bronzeapp;
package com.incubate.code.spartanapp;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import me.relex.circleindicator.CircleIndicator;



public class ViewPagerActivity extends AppCompatActivity {

    ViewPager viewPager;
    private TextView next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        viewPager = (ViewPager)findViewById(R.id.pager);
        next = (TextView)findViewById(R.id.next);
        final ViewPagerAdapter adapter = new ViewPagerAdapter
                (getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                viewPager.setCurrentItem(getItem(+1), true);

            }
        });


    }


    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }
}
