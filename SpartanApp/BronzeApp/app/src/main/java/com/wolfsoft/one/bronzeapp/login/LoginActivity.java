package com.wolfsoft.one.bronzeapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.wolfsoft.one.bronzeapp.R;
import com.wolfsoft.one.bronzeapp.calendar.HorizontalCalendarActivity;
import com.wolfsoft.one.bronzeapp.database.DBHandler;

public class LoginActivity extends AppCompatActivity {

    TextView inputID;
    TextView inputPWD;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbHandler = new DBHandler(this);
        inputID = (TextView) findViewById(R.id.textInputID);
        inputPWD = (TextView) findViewById(R.id.textInputPWD);
    }

    public void gotToSignUp(View v){
        Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);

        startActivity(intent);
    }

    public void signIn(View v){
        CharSequence pwd = inputPWD.getText();
        CharSequence user = inputID.getText();

        if(dbHandler.precedeLogin(user.toString(), pwd.toString())){
            Intent intent = new Intent(getApplicationContext(), HorizontalCalendarActivity.class);

            startActivity(intent);
        }else{
            Toast.makeText(this, "username or password are wrong", Toast.LENGTH_LONG).show();
        }
    }
}
