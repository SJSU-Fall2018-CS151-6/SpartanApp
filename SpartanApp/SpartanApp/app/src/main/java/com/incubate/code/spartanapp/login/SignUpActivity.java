//package com.wolfsoft.one.bronzeapp.login;
package com.incubate.code.spartanapp.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.incubate.code.spartanapp.R;
import com.incubate.code.spartanapp.database.DBHandler;

/**
 * Activity to show the sign uop screen
 */

public class SignUpActivity extends AppCompatActivity {

    DBHandler dbHandler;
    EditText textViewNewID;
    EditText textViewNewName;
    EditText textViewNewPWD;
    EditText textViewNewEmail;
    EditText textViewNewBirth;


    /**
     * initializing the view
     */

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

    /**
     * Button clicked to go to the signup screen
     * @param v the view that is calling
     */
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
