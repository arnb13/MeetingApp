package com.example.meeting;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbHelper extends SQLiteOpenHelper {

        public static final String dbName = "meeting.db";
        public static final String tableName = "meetingSchedule";
        public static final String col_id = "id";
        public static final String col_name = "name";
        public static final String col_address = "address";
        public static final String col_company = "company";
        public static final String col_designation = "designation";
        public static final String col_time = "time";
        public static final String col_inTime = "inTime";
        public static final String col_outTime = "outTime";
        public static final String col_lat = "lat";
        public static final String col_lon = "lon";
        public static final String col_flag = "flag";


    public dbHelper(@Nullable Context context) {
        super(context, dbName, null, 1);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table client " +
                "(id integer primary key autoincrement, " +
                col_name + " text," +
                col_address +" text," +
                col_company + " text," +
                col_designation + " text," +
                col_time + " integer," +
                col_inTime + " integer," +
                col_outTime + " integer," +
                col_lat + " decimal," +
                col_lon + " decimal," +
                col_flag + " integer)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + tableName);
        onCreate(db);

    }

    public boolean insertData(String name, String address, String company, String designation, long time, long inTime, long outTime, float lat, float lon, int flag) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(col_name, name);
        contentValues.put(col_address, address);
        contentValues.put(col_company, company);
        contentValues.put(col_designation, designation);
        contentValues.put(col_time, time);
        contentValues.put(col_inTime, inTime);
        contentValues.put(col_outTime, outTime);
        contentValues.put(col_lat, lat);
        contentValues.put(col_lon, lon);
        contentValues.put(col_flag, flag);
        if (db.insert(tableName, null, contentValues) == -1) {
            return false;
        } else {
            return true;
        }

    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + tableName, null);

        return res;

    }


}
