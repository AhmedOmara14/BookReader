package tra.wor.bookreader.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import tra.wor.bookreader.pojo.imageLinks;
import tra.wor.bookreader.pojo.items;
import tra.wor.bookreader.pojo.volumeInfo;

public class database extends SQLiteOpenHelper {
    private static final String DB_name="database";
    private static final String TAG = "DatabaseHelper";
    public database(@Nullable Context context) {
        super(context, DB_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE Favorite (image TEXT ,title TEXT PRIMARY KEY,author TEXT,des TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Favorite");
        onCreate(db);
    }

    public boolean addData(String image,String title,String author,String des) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("image", image);
        contentValues.put("title", title);
        contentValues.put("author", author);
        contentValues.put("des", des);

        long result = db.insert("Favorite", null, contentValues);

        //if date as inserted incorrectly it will return -1
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }
    public ArrayList<items> getAllElements() {

        ArrayList list = new ArrayList();

        // Select All Query
        String selectQuery = "SELECT  * FROM Favorite" ;

        SQLiteDatabase db = this.getReadableDatabase();
        try {

            Cursor cursor = db.rawQuery(selectQuery, null);
            try {

                if (cursor.moveToFirst()) {
                    do {
                        String image=cursor.getString(cursor.getColumnIndex("image"));
                        String title=cursor.getString(cursor.getColumnIndex("title"));
                        String author=cursor.getString(cursor.getColumnIndex("author"));
                        String des=cursor.getString(cursor.getColumnIndex("des"));
                        ArrayList authorlist=new ArrayList();
                        authorlist.add(author);
                        imageLinks imageLinks=new imageLinks();
                        imageLinks.setThumbnail(image);
                        volumeInfo volumeInfo=new volumeInfo(title,authorlist,des,imageLinks);
                        items items =new items();
                        items.setVolumeInfo(volumeInfo);

                        list.add(items);

                    } while (cursor.moveToNext());
                }

            } finally {
                try { cursor.close(); } catch (Exception ignore) {}
            }

        } finally {
            try { db.close(); } catch (Exception ignore) {}
        }

        return list;
    }


}
