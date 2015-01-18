package com.greatebhavin.sunshine;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bhavin on 9/25/2014.
 */
public class CommandDataSource {

    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    private String[] allColumns = { DatabaseHelper.COLUMN_ID,DatabaseHelper.COLUMN_DEBIT,DatabaseHelper.COLUMN_CREDIT };

    public CommandDataSource(Context context) {
        this.dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException
    {
        database = dbHelper.getWritableDatabase();
    }

    public void close()
    {
        dbHelper.close();
    }

    public Expense createRecord(String debit , String credit)
    {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_CREDIT,credit);
        values.put(DatabaseHelper.COLUMN_DEBIT,debit);
        long insertedId = database.insert(DatabaseHelper.TABLE_EXPENSES,null,values);
        Cursor cursor = database.query(DatabaseHelper.TABLE_EXPENSES,allColumns,DatabaseHelper.COLUMN_ID+" = "+insertedId,null,null,null,null);
        cursor.moveToFirst();
        Expense expense = CursorToComment(cursor);
        cursor.close();
        return expense;
    }

    public void deleteExpanse(Expense expense)
    {
        long id = expense.getId();
        System.out.println("Need to delete the id:"+id);
        database.delete(DatabaseHelper.TABLE_EXPENSES,DatabaseHelper.COLUMN_ID+" = "+id,null);
    }

    public List<Expense> getAllExpanse()
    {
        List<Expense> expenses = new ArrayList<Expense>();
        Cursor cursor = database.query(DatabaseHelper.TABLE_EXPENSES,allColumns,null,null,null,null,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast())
        {
            Expense expense = CursorToComment(cursor);
            expenses.add(expense);
            cursor.moveToNext();
        }
        cursor.close();
        return expenses;
    }
   private Expense CursorToComment(Cursor cursor)
   {
       Expense expense =new Expense();
       expense.setId(cursor.getLong(0));
       expense.setCredit(cursor.getString(1));
       expense.setDebit(cursor.getString(2));
       return expense;
   }
}
