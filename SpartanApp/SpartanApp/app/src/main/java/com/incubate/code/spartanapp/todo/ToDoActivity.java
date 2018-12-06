//package com.wolfsoft.one.bronzeapp.todo;
package com.incubate.code.spartanapp.todo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.incubate.code.spartanapp.R;
import com.incubate.code.spartanapp.general.Behavior;
import com.incubate.code.spartanapp.home.HomeActivity;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

//import com.wolfsoft.one.bronzeapp.general.Behavior;
//import com.wolfsoft.one.bronzeapp.home.HomeActivity;

public class ToDoActivity extends AppCompatActivity implements Behavior {

    Timer timer = new Timer();
    Timer timer2 = new Timer();
    TimerTask consumerThread;
    ArrayList<String> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        final ListView listView = (ListView) findViewById(R.id.todoListView);
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        consumerThread = new TimerTask() {
            @Override
            public void run() {
                try {
                    System.out.println("wird ausgefuehrt");
                    int size = com.incubate.code.spartanapp.todo.MassageQueue.getInstance().size();
                    if(size > 0){
                        com.incubate.code.spartanapp.todo.Assignment a = (com.incubate.code.spartanapp.todo.Assignment) com.incubate.code.spartanapp.todo.MassageQueue.getInstance().take();
                        Log.e("received from queue", a.getName());
                        list.add(a.getName());

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter.notifyDataSetChanged();
                            }
                        });
                    }

                }catch (InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        };

    }
    @Override
    public void goHome(View v) {
        Intent intent = new Intent(getApplicationContext(), HomeActivity.class);

        startActivity(intent);
    }

    public void subscribe(View v){
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage("You subscribe now to course notifications");
        dlgAlert.setTitle("Subscribe");
        dlgAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                timer.schedule(new com.incubate.code.spartanapp.todo.CourseNotificationCreator(),1000,1000);

                timer.schedule(consumerThread,0,1000);
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
    }
}
