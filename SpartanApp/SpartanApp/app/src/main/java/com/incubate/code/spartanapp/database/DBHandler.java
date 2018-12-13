//package com.wolfsoft.one.bronzeapp.database;
package com.incubate.code.spartanapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

//import com.wolfsoft.one.bronzeapp.login.Credentials;
import com.incubate.code.spartanapp.login.Credentials;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * This class is for dealing with the database in a more abstract way
 */

public class DBHandler implements Runnable, Serializable {

    private Context context;
    private SQLiteDatabase databaseWrite;
    private SQLiteDatabase databaseRead;

    /**
     * constructor
     * @param context
     */
    public DBHandler(Context context){
        this.context = context;
        Thread thread = new Thread(this);
        thread.start();
    }

    /**
     * for creating a new user into the database
     *
     * @param id the student id
     * @param name the student name
     * @param email the email of the user
     * @param password the password for the login
     * @param birthday the users birthday
     */
    public void newUser(String id, String name, String email, String password, String birthday) {

        ContentValues values = new ContentValues();
        values.put(DBConfig.UserData.NAME, name);
        values.put(DBConfig.UserData.STUDENT_ID, id);
        values.put(DBConfig.UserData.EMAIL, email);
        values.put(DBConfig.UserData.PASSWORD, password);


        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime((new SimpleDateFormat("MM/dd/yyyy")).parse(birthday));
            long date = calendar.getTimeInMillis();
            values.put(DBConfig.UserData.BIRTHDAY, date);
        }
        catch (Exception e) {
            Log.e("sql save", "Error", e);
            Toast.makeText(context, "Date is in the wrong format", Toast.LENGTH_LONG).show();
            return;
        }
        long newRowId = databaseWrite.insert(DBConfig.UserData.TABLE_NAME, null, values);

        Log.e("NewDBElement", "The new Row Id is " + newRowId);
        Toast.makeText(context, "You signed up successfully", Toast.LENGTH_SHORT).show();
    }


    /**
     * for checking if the login date was correct
     *
     * @param id sutdent id
     * @param password account password
     * @return true for success and false failure
     */
    public Boolean precedeLogin(String id, String password) {

        String[] projection = {
                DBConfig.UserData.STUDENT_ID,
                DBConfig.UserData.NAME,
                DBConfig.UserData.EMAIL,
                DBConfig.UserData.BIRTHDAY,
                DBConfig.UserData.PASSWORD
        };

        String whereClause = DBConfig.UserData.STUDENT_ID+" = ?";
        String [] whereArgs = {id};

        Cursor cursor;
        try {
            cursor = databaseRead.query(
                    DBConfig.UserData.TABLE_NAME,     // The table to query
                    projection,                               // The columns to return
                    whereClause,                                // The columns for the WHERE clause
                    whereArgs,                            // The values for the WHERE clause
                    null,                                     // don't group the rows
                    null,                                     // don't filter by row groups
                    null                                     // don't sort
            );

        }catch (Exception e){
            return false;
        }

        Log.d("read sql", "The total cursor count is " + cursor.getCount());

        if (cursor.getCount() == 0) return false;

        cursor.moveToFirst();
        String pwd = cursor.getString(cursor.getColumnIndexOrThrow(DBConfig.UserData.PASSWORD));

        if(pwd.equals(password)){
            String email = cursor.getString(cursor.getColumnIndexOrThrow(DBConfig.UserData.EMAIL));
            long birthday = cursor.getLong(cursor.getColumnIndexOrThrow(DBConfig.UserData.BIRTHDAY));
            String name = cursor.getString(cursor.getColumnIndexOrThrow(DBConfig.UserData.NAME));
            Credentials.setPassword(pwd);
            Credentials.setBirthday(new Date(birthday));
            Credentials.setUserName(name);
            Credentials.setEmail(email);
            Credentials.setUserID(id);
            return true;
        }
        return false;
    }

    /**
     * for running the opening of the databases in a thread
     */

    @Override
    public void run() {
        databaseRead = new com.incubate.code.spartanapp.database.DBHelper(context).getReadableDatabase();
        databaseWrite = new com.incubate.code.spartanapp.database.DBHelper(context).getWritableDatabase();
    }
}
