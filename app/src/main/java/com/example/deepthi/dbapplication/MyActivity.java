package com.example.deepthi.dbapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class MyActivity extends Activity {
    public final static String EXTRA_MESSAGE = "com.example.deepthi.dbapplication.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
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

    public void onSubmitClick(View view){
        //Create an Employee instance to store the values entered by the user in UI
        Employee emp= new Employee();
        String technology="";
        DatePicker dp = (DatePicker) findViewById(R.id.inputDate);
        String date=  dp.getYear()+"-"+dp.getMonth()+"-"+dp.getDayOfMonth();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        EmployeeDBImplementer empDb = new EmployeeDBImplementer();
        try {
            emp.NAME = ((EditText) findViewById(R.id.inputName)).getText().toString();

            //Radio Buttons
            int radioId = (((RadioGroup) findViewById(R.id.inputType)).getCheckedRadioButtonId());
            emp.TYPE = ((RadioButton) findViewById(radioId)).getText().toString();

            //Adding the parsed date from UI to Joining Date
            //emp.JOINING = df.parse(date);
            emp.JOINING = date;

            //Check each Check box if it is checked or not
            if(((CheckBox) findViewById(R.id.checkbox_java)).isChecked())
                    technology =((CheckBox) findViewById(R.id.checkbox_java)).getText().toString();
            if(((CheckBox) findViewById(R.id.checkbox_android)).isChecked())
                technology  = technology+ " and "+((CheckBox) findViewById(R.id.checkbox_android)).getText().toString();
            emp.TECH =technology;
            //Store the country into employee object
            //emp.COUNTRY= ((Spinner) findViewById(R.id.inputCountry)).getSelectedItem().toString();

            // Now call the onInsert method of EmployeeDBImplementer to insert the values into the DB
            Intent intent = new Intent(this, EmployeeDBImplementer.class);
            intent.putExtra("Myobj", emp);
            startActivity(intent);
           // long newRowId= empDb.onInsert(emp);
            //String text="A row is inserted at"+" "+newRowId;
            String text="A row is inserted";
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();



        }
        catch(Exception e){
            System.out.println("Exception during date parsing"+e);
        }




    }
}
