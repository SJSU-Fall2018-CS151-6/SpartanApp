package com.wolfsoft.one.bronzeapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.wolfsoft.one.bronzeapp.R;
import com.wolfsoft.one.bronzeapp.database.DBHandler;
import com.wolfsoft.one.bronzeapp.home.HomeActivity;

public class SignUpActivity extends AppCompatActivity {

    DBHandler dbHandler;
    EditText textViewNewID;
    EditText textViewNewName;
    EditText textViewNewPWD;
    EditText textViewNewEmail;
    EditText textViewNewBirth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        dbHandler = new DBHandler(this);
        textViewNewID = (EditText) findViewById(R.id.textInputNewID);
        textViewNewName = (EditText) findViewById(R.id.textInputNewName);
        textViewNewEmail = (EditText) findViewById(R.id.textInputNewEmail);
        textViewNewPWD = (EditText) findViewById(R.id.textInputNewPWD);
        textViewNewBirth = (EditText) findViewById(R.id.textInputNewBirth);
    }

    public void signUp(View v){
        String id = textViewNewID.getText().toString();
        String email = textViewNewEmail.getText().toString();
        String birth = textViewNewBirth.getText().toString();
        String pwd = textViewNewPWD.getText().toString();
        String name = textViewNewName.getText().toString();

        dbHandler.newUser(id, name, email, pwd, birth);

        onBackPressed();
    }

    public void goToSignIn(View v){
        finish();
    }
}
