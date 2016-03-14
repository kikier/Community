package com.kikier.community;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Yz on 2016/3/5.
 */
public class DBDao {
    static Cursor cursor;
    static MainOpenHelper helper;
    static SQLiteDatabase db;
    public static Cursor query(Context context,String table, String[] columns, String selection,
                               String[] selectionArgs, String groupBy, String having,
                               String orderBy){
        helper = new MainOpenHelper(context);
        db = helper.getWritableDatabase();
        cursor = db.query(table,columns,selection,selectionArgs,groupBy,having,orderBy);
        return cursor;
    }
}
