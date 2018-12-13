//package com.wolfsoft.one.bronzeapp.database;
package com.incubate.code.spartanapp.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.Serializable;

/**
 * this class is for handling the db
 */

public class DBHelper extends SQLiteOpenHelper implements Serializable {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "sparta";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DBConfig.UserData.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int ii) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DBConfig.UserData.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
