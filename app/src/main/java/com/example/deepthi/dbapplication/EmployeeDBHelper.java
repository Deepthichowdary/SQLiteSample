package com.example.deepthi.dbapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.text.SimpleDateFormat;

/**
 * Created by Deepthi Chowdary on 16-08-14.
 */
public class EmployeeDBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "FeedReader.db";
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SPACE_SEP = " ";
    Context context;
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Employee.TABLE_NAME + "(" +
                    Employee._ID + " INTEGER PRIMARY KEY," +
                    Employee.COLUMN_TITLE_NAME +SPACE_SEP+ "Text" + COMMA_SEP +
                    Employee.COLUMN_TITLE_TYPE +SPACE_SEP+ "Text"+ COMMA_SEP +
                    Employee.COLUMN_TITLE_JOINING +SPACE_SEP+"Text" + COMMA_SEP +
                    Employee.COLUMN_TITLE_TECH + SPACE_SEP+ "Text" + COMMA_SEP +
                    Employee.COLUMN_TITLE_COUNTRY +SPACE_SEP+"Text" +
                    " );";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Employee.TABLE_NAME;

    public EmployeeDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


}