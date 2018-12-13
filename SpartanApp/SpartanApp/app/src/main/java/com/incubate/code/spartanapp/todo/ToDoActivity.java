package com.incubate.code.spartanapp.todo;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.incubate.code.spartanapp.R;
import com.incubate.code.spartanapp.general.Behavior;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * This class defines the ToDoActivity, where all assignments are displayed
 */

public class ToDoActivity extends AppCompatActivity implements Behavior {

    Timer timer = new Timer();
    Timer timer2 = new Timer();
    TimerTask consumerThread;
    RecyclerView recyclerView;
    RecyclerViewAdapter mAdapter;
    ArrayList<Assignment> assignmentList = new ArrayList<>();


    /**
     * initializing the view
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new RecyclerViewAdapter(assignmentList);
        recyclerView.setAdapter(mAdapter);


        consumerThread = new TimerTask() {
            @Override
            public void run() {
                try {
                    System.out.println("timer in execution");
                    int size = com.incubate.code.spartanapp.todo.MassageQueue.getInstance().size();
                    if(size > 0){
                        com.incubate.code.spartanapp.todo.Assignment a = (com.incubate.code.spartanapp.todo.Assignment) com.incubate.code.spartanapp.todo.MassageQueue.getInstance().take();
                        Log.e("received from queue", a.getName());
                        assignmentList.add(a);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mAdapter.notifyDataSetChanged();
                            }
                        });
                    }

                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        };


    }

    /**
     * implementation of the interface to have a way to go to the homescreen
     * @param v the calling view
     */
    @Override
    public void goHome(View v) {
        onBackPressed();
    }

    /**
     * for starting the threads consumer, producer
     * @param v button that has been clicked
     */
    public void subscribe(View v){
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("You subscribe now to course notifications");
        dlgAlert.setTitle("Subscribe");
        dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                timer.schedule(new com.incubate.code.spartanapp.todo.CourseNotificationCreator(),1000,9000);

                timer2.schedule(consumerThread,0,10000);
            }
        });
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
        timer.purge();
        timer2.cancel();
        timer2.purge();
    }


}
