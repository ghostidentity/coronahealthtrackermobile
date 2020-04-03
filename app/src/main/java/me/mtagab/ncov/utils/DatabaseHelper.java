package me.mtagab.ncov.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import me.mtagab.ncov.model.Tasks;

public class DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE accounts (Id INTEGER PRIMARY KEY AUTOINCREMENT, taskname TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addTasks(Tasks temp) {
        ContentValues values = new ContentValues();
        values.put("taskname", temp.getTaskname());
        SQLiteDatabase db = getWritableDatabase();
        db.insert("accounts", null, values);

        String query = "SELECT * FROM accounts";
        System.out.println("Records: " + db.rawQuery(query, null).getCount());

        db.close();
    }

    public void removeTask(String taskname) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM accounts where Id = 1");
    }

    public String getRecords() {

        System.out.print("running....");

        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM accounts where 1";


        Cursor c = db.rawQuery(query, null);

        System.out.println("Records: " + db.rawQuery(query, null).getCount());
        c.moveToFirst();

        while(!c.isAfterLast()) {
           if(c.getString(c.getColumnIndex("taskname")) != null) {
                dbString += c.getString(c.getColumnIndex("taskname"));
           }
           c.moveToNext();
        }

        db.close();


        System.out.print("running.... " + dbString);
        return dbString;
    }
}
