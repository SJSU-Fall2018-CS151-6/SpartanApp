package com.wolfsoft.one.bronzeapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DBHandler {

    private Context context;

    public DBHandler(Context context){
        this.context = context;
    }

    public void newUser(String name, String email, String password, String birthday) {
        SQLiteDatabase database = new DBHelper(context).getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBConfig.UserData.NAME, name);
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
        long newRowId = database.insert(DBConfig.UserData.TABLE_NAME, null, values);

        Toast.makeText(context, "The new Row Id is " + newRowId, Toast.LENGTH_LONG).show();
    }


    public Boolean precedeLogin(String name, String password) {

        SQLiteDatabase database = new DBHelper(context).getReadableDatabase();

        String[] projection = {
                DBConfig.UserData.PASSWORD
        };

        String whereClause = DBConfig.UserData.NAME+" = ?";
        String [] whereArgs = {name};

        Cursor cursor;
        try {
            cursor = database.query(
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

        Toast.makeText(context, pwd, Toast.LENGTH_LONG).show();

        return pwd.equals(password);
    }




}
