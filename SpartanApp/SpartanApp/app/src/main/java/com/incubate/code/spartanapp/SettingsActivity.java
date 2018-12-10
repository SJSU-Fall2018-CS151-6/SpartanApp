//package com.wolfsoft.one.bronzeapp;
package com.incubate.code.spartanapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.incubate.code.spartanapp.login.Credentials;

import customfonts.MyTextView;


public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        MyTextView textView = (MyTextView) findViewById(R.id.settingsUserNameLabel);
        textView.setText(Credentials.getUserName());
    }
}
