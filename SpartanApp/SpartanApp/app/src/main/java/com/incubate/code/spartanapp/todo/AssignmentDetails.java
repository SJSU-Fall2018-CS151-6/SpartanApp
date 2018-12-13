package com.incubate.code.spartanapp.todo;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.View;

/**
 * for giving a popup to show some more details for every Assignment in the list
 */

public class AssignmentDetails implements View.OnClickListener {
    Context context;

    AssignmentDetails(Context context){
        this.context = context;
    }


    private void showPopUp(String name){
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(context);
        dlgAlert.setMessage(name);
        dlgAlert.setTitle("DetailView");
        dlgAlert.setCancelable(true);
        dlgAlert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dlgAlert.create().show();
    }

    @Override
    public void onClick(View view) {
        //String item = (String) adapterView.getItemAtPosition(i);
        showPopUp("test");
    }
}
