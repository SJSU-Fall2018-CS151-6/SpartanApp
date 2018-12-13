
package com.incubate.code.spartanapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.incubate.code.spartanapp.R;
import com.incubate.code.spartanapp.database.DBHandler;
import com.incubate.code.spartanapp.home.HomeActivity;

/**
 * The login screen
 */
public class LoginActivity extends AppCompatActivity {

    TextView inputID;
    TextView inputPWD;
    DBHandler dbHandler;

    /**
     * initializing the screen
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dbHandler = new DBHandler(this);
        inputID = (TextView) findViewById(R.id.textInputID);
        inputPWD = (TextView) findViewById(R.id.textInputPWD);
    }

    /**
     * Button clicked to go to the SignUp screen
     * @param v the view that is calling
     */
    public void gotToSignUp(View v){
        Intent intent = new Intent(getApplicationContext(), com.incubate.code.spartanapp.login.SignUpActivity.class);

        startActivity(intent);
    }

    /**
     * Button clicked to go to the sing in screen
     * @param v the view that is calling
     */
    public void signIn(View v){
        CharSequence pwd = inputPWD.getText();
        CharSequence user = inputID.getText();

        if(dbHandler.precedeLogin(user.toString(), pwd.toString())){
            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);

            startActivity(intent);
        }else{
            Toast.makeText(this, "username or password are wrong", Toast.LENGTH_LONG).show();
        }
    }
}
