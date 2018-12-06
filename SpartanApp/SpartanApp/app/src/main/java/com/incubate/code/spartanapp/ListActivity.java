//package com.wolfsoft.one.bronzeapp;
package com.incubate.code.spartanapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ListView list;
    private ListLayoutAdapter listLayoutAdapter;

    private String[] TITLES = {"Apple", "Banana", "Chikoo", "Orange", "Pineple", "Guava",
            "Strawberry", "Juice", "Bread","Cheese","Milk","Yogut"};


    private ArrayList<List> listArrayList;


    // f8f8f9

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_layout);


        list = (ListView)findViewById(R.id.list);

        listArrayList = new ArrayList<List>();

        for (int i=0; i<TITLES.length; i++){

            List list = new List();
            list.setTitle(TITLES[i]);

            listArrayList.add(list);

        }

        listLayoutAdapter = new ListLayoutAdapter(ListActivity.this, listArrayList);
        list.setAdapter(listLayoutAdapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                if (listArrayList.get(position).isHasRight() == false){

                    listArrayList.get(position).setHasRight(true);
                }else {
                    listArrayList.get(position).setHasRight(false);
                }


                listLayoutAdapter.notifyDataSetChanged();



            }
        });




    }
}
