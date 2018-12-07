package com.incubate.code.spartanapp.database;

import android.provider.BaseColumns;

/**
 *
 *
 */

class DBConfig {

    static class UserData implements BaseColumns {
        static final String TABLE_NAME = "userData";
        static final String STUDENT_ID = "student_id";
        static final String NAME = "name";
        static final String EMAIL = "email";
        static final String PASSWORD = "password";
        static final String BIRTHDAY = "birthday";

        static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                STUDENT_ID + " TEXT PRIMARY KEY, " +
                NAME + " TEXT, " +
                EMAIL + " TEXT, " +
                PASSWORD + " TEXT, "+
                BIRTHDAY+" INTEGER)";
    }
}
