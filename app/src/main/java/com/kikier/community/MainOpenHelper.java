package com.kikier.community;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Yz on 2016/3/4.
 */
    public class MainOpenHelper extends SQLiteOpenHelper implements BaseColumns{
    static String DB_NAME = "main.db";
    static int DB_VERSION = 1;

    public MainOpenHelper(Context context) {
        super(context,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table news(" +
                "_id integer primary key autoincrement," +
                "title varchar(50) not null," +
                "author varchar(30) not null," +
                "content varchar(2000) not null," +
                "time varchar(30))";
        String sql2 = "create table news_pic(" +
                "aid integer primary key autoincrement," +
                "fk_id integer," +
                "path varchar(100)," +
                "foreign key(fk_id) references news(_id))";
        db.execSQL(sql);
        db.execSQL(sql2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
