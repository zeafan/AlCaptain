package com.zeafan.alcaptain.data;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.zeafan.alcaptain.core.GlobalClass;

import java.util.Date;

public class DBAdapter {
    public static final String DATABASE_NAME = "DistributionData.db";
    private static final int DATABASE_VERSION = 7;
    public static final String DATABASE_BACKUP_NAME = ("DistributionData_" + GlobalClass.StaticCore.DateToString(new Date(), GlobalClass.DATE_FORMAT) + "_backup.db").replace(":", "_");


    public static SQLiteDatabase database;
    private static DatabaseHelper databaseHelper;
    final Context context;

    public DBAdapter(Context ctx) {
        context = ctx;

        if (databaseHelper == null) {
            databaseHelper = new DatabaseHelper(context);
        }
    }

    //---opens the database---
    public DBAdapter Open() throws SQLException {
        database = databaseHelper.getWritableDatabase();
        return this;
    }

    public void ExecuteSQL(String sql) {
        //Open();
        database = databaseHelper.getWritableDatabase();
        database.execSQL(sql);
        database.close();
        //Close();
    }

    //---closes the database---
    public void Close() {
        databaseHelper.close();
    }

    private class DatabaseHelper extends SQLiteOpenHelper {
        private DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {


            } catch (Exception e) {
                GlobalClass.StaticCore.SendRepotEx(e);
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                if (newVersion > oldVersion) {

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
