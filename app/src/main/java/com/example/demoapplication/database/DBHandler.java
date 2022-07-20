package com.example.demoapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.demoapplication.movie.MovieResult;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME =  "movie database";

    private static final Integer DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "mycourses";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our course name column
    private static final String NAME_COL = "name";

    // below variable id for our course duration column.
    private static final String DURATION_COL = "releaseDate";

    // below variable for our course description column.
    private static final String DESCRIPTION_COL = "description";

    // below variable is for our course tracks column.
    private static final String TRACKS_COL = "image";

    public DBHandler(Context context) {
        super(context, DB_NAME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + DURATION_COL + " TEXT,"
                + DESCRIPTION_COL + " TEXT,"
                + TRACKS_COL + " TEXT)";

        sqLiteDatabase.execSQL(query);

    }

    public void getData() {
        SQLiteDatabase database = this.getReadableDatabase();

        String[] projection = {
                NAME_COL,
                ID_COL
        };

        String selection = DURATION_COL + " = ?";

        String[] selectionArgs = {"2022-03-03", "2022-05-05"};

        String sortOrder = NAME_COL + " DESC";

        Cursor cursor = database.query(
                TABLE_NAME,   // The table to query
                null,             // The array of columns to return (pass null to get all)
                null,              // The columns for the WHERE clause
                null,          // The values for the WHERE clause
                null,                   // don't group the rows
                null,                   // don't filter by row groups
                sortOrder               // The sort order
        );

        ArrayList<MovieResult> resultsData = new ArrayList<MovieResult>();

        if(cursor.moveToFirst()) {
            do{
                MovieResult movie = new MovieResult();
                movie.setId(cursor.getInt(0));
                movie.setOriginalTitle(cursor.getString(1));
                resultsData.add(movie);

            } while (cursor.moveToNext());
        }

        Log.d("size of list", String.valueOf(resultsData.size()));
        cursor.close();
    }

    public ArrayList<MovieResult> getResults() {
        ArrayList<MovieResult> resultsData = new ArrayList<MovieResult>();

        SQLiteDatabase database = this.getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_NAME, null);

        if(cursor.moveToFirst()) {
            do{
                MovieResult movie = new MovieResult();
                movie.setId(cursor.getInt(0));
                movie.setOriginalTitle(cursor.getString(1));
                resultsData.add(movie);

            } while (cursor.moveToNext());
        }

        Log.d("size of list", String.valueOf(resultsData.size()));
        cursor.close();

        return resultsData;
    }

    public void insertNewData(String movieName, String releaseDate, String description, String image) {
        SQLiteDatabase database = this.getWritableDatabase();

        onUpgrade(database, 1, 2);

        ContentValues values = new ContentValues();
        values.put(NAME_COL, movieName);
        values.put(DURATION_COL, releaseDate);
        values.put(DESCRIPTION_COL, description);
        values.put(TRACKS_COL, image);

        database.insert(TABLE_NAME, null, values);

        database.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
