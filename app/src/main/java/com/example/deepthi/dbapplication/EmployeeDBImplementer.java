package com.example.deepthi.dbapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.example.deepthi.dbapplication.R;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;


import java.text.SimpleDateFormat;


public class EmployeeDBImplementer extends Activity {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public final static String EXTRA_MESSAGE = "com.example.deepthi.dbapplication.MESSAGE";
    public long onInsert(Employee emp) {
        EmployeeDBHelper mDbHelper = new EmployeeDBHelper(this.getApplicationContext());
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(emp.COLUMN_TITLE_NAME, emp.NAME);
        values.put(emp.COLUMN_TITLE_TYPE, emp.TYPE);
        values.put(emp.COLUMN_TITLE_JOINING, emp.JOINING);

        values.put(emp.COLUMN_TITLE_TECH, emp.TECH);
        values.put(emp.COLUMN_TITLE_COUNTRY, emp.COUNTRY);


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                Employee.TABLE_NAME,
                null,
                values);
        return newRowId;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        //onInsert()
        Employee emp = (Employee) getIntent().getSerializableExtra("Myobj");
        onInsert(emp);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.employee_dbimplementer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
