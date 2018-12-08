package com.incubate.code.spartanapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;


import com.incubate.code.spartanapp.login.Credentials;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * This class implement the database handler class
 *
 */

public class DBHandler implements Runnable, Serializable {

    private Context context;
    private SQLiteDatabase databaseWrite;
    private SQLiteDatabase databaseRead;

    /**
     * Constructor class for DBHandler
     * @param context
     */
    public DBHandler(Context context){
        this.context = context;
        Thread thread = new Thread(this);
        thread.start();
    }

    /**
     * Create New user
     * @param id
     * @param name
     * @param email
     * @param password
     * @param birthday
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
     * Handel the Login process
     * @param id
     * @param password
     * @return
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
     *
     */
    @Override
    public void run() {
        databaseRead = new com.incubate.code.spartanapp.database.DBHelper(context).getReadableDatabase();
        databaseWrite = new com.incubate.code.spartanapp.database.DBHelper(context).getWritableDatabase();
    }
}
