package com.ajayvyas.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ajay on 1/4/17.
 */

public class MySQLiteHelper extends SQLiteOpenHelper{
    public static String TABLE_COMMENTS = "comments";
    public static String COLUMN_ID = "_id";
    public static String COLUMN_COMMENT = "comment";

    private static String DATABASE_NAME = "commments.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    /*private static String DATABASE_CREATE = "create table "
            + TABLE_COMMENTS + "( " + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_COMMENT
            + " text not null);";*/

    private static String DATABASE_CREATE ="CREATE TABLE Ajay( id integer AUTOINCREMENT, emp_id int(11) , name varchar(45) , sex varchar(10)  );";


    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Called","DataBase Created");
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        try {
            database.execSQL(DATABASE_CREATE);
            Log.d("Called","DataBase Query right");
        }
        catch (Exception e)
        {
            Log.d("Called","DataBase query error"+e.getMessage());
        }
        Log.d("Called","DataBase Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
        onCreate(db);
    }

}
