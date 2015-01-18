package com.greatebhavin.sunshine;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Bhavin on 9/25/2014.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_EXPENSES = "Expense", COLUMN_ID = "_id", COLUMN_DEBIT = "debit", COLUMN_CREDIT = "credit";
    public static final String DATABASE_CREATE = "CREATE TABLE" +
            TABLE_EXPENSES + "(" + COLUMN_ID + "" +
            " integer primary key AUTOINCREMENT," + COLUMN_CREDIT + " text not null," + COLUMN_DEBIT + " text not null);";
    public static final String DATABASE_NAME = "expense.db";
    public static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EXPENSES);
        onCreate(sqLiteDatabase);
    }
}
