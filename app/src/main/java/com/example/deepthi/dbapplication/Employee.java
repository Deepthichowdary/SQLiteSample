package com.example.deepthi.dbapplication;

import android.provider.BaseColumns;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Deepthi Chowdary on 16-08-14.
 */
public class Employee implements BaseColumns,Serializable {

     public static final String TABLE_NAME = "employee";

     public static final String COLUMN_TITLE_NAME = "Name";
     public static final String COLUMN_TITLE_TYPE = "Type";
     public static final String COLUMN_TITLE_JOINING = "Joining";
     public static final String COLUMN_TITLE_TECH = "Technology";
     public static final String COLUMN_TITLE_COUNTRY = "Country";


      public static  String NAME = "";
      public static String TYPE = "";
      public static String JOINING =null;
      public static String TECH = "";
      public static String COUNTRY = "";

}
