package com.wolfsoft.one.bronzeapp.database;

import android.provider.BaseColumns;

class DBConfig {

    static class UserData implements BaseColumns {
        static final String TABLE_NAME = "userData";
        static final String NAME = "name";
        static final String EMAIL = "email";
        static final String PASSWORD = "password";
        static final String BIRTHDAY = "birthday";

        static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NAME + " TEXT, " +
                EMAIL + " TEXT, " +
                PASSWORD + " TEXT, "+
                BIRTHDAY+" INTEGER)";
    }
}
