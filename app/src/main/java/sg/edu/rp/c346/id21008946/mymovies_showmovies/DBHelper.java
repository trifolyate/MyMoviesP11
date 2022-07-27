package sg.edu.rp.c346.id21008946.mymovies_showmovies;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "movies.db";
    private static final int DATABASE_VERSION = 2;
    private static final String TABLE_MOVIES = "movies";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_MOVIETITLE = "movie_title";
    private static final String COLUMN_MOVIEGENRE = "movie_genre";
    private static final String COLUMN_MOVIEYEAR = "movie_year";
    private static final String COLUMN_MOVIERATING = "movie_rating";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createNoteTableSql = "CREATE TABLE " + TABLE_MOVIES + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_MOVIETITLE + " TEXT , "
                + COLUMN_MOVIEGENRE + " TEXT , "
                + COLUMN_MOVIEYEAR + " INTEGER , "
                + COLUMN_MOVIERATING + " TEXT ) ";
        db.execSQL(createNoteTableSql);

        Log.i("info", "created tables");

//        //Dummy records, to be inserted when the database is created
//        for (int i = 0; i< 4; i++) {
//            ContentValues values = new ContentValues();
//            values.put(COLUMN_NOTE_CONTENT, "Data number " + i);
//            db.insert(TABLE_NOTE, null, values);
//        }
//        Log.i("info", "dummy records inserted");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);
//        onCreate(db);
        db.execSQL("ALTER TABLE " + TABLE_MOVIES + " ADD COLUMN  module_name TEXT ");
    }

    public long insertMovie(String title, String genre, int year,String rating) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_MOVIETITLE, title);
        values.put(COLUMN_MOVIEGENRE, genre);
        values.put(COLUMN_MOVIEYEAR, year);
        values.put(COLUMN_MOVIERATING, rating);
        long result = db.insert(TABLE_MOVIES, null, values);
        db.close();
        Log.d("SQL Insert","ID:"+ result); //id returned, shouldn’t be -1
        return result;
    }

    public ArrayList<Movies> getAllMovies() {
        ArrayList<Movies> songs = new ArrayList<Movies>();

        SQLiteDatabase db = this.getReadableDatabase();
        //        COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
//                + COLUMN_MOVIETITLE + " TEXT , "
//                + COLUMN_MOVIEGENRE + " TEXT , "
//                + COLUMN_MOVIEYEAR + " INTEGER , "
//                + COLUMN_MOVIERATING + " TEXT ) ";
        String[] columns= {COLUMN_ID, COLUMN_MOVIETITLE, COLUMN_MOVIEGENRE, COLUMN_MOVIEYEAR, COLUMN_MOVIERATING };
        Cursor cursor = db.query(TABLE_MOVIES, columns, null, null,
                null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String genre = cursor.getString(2);
                int year = cursor.getInt(3);
                String rating = cursor.getString(4);
                Movies song = new Movies(id,title,genre,year,rating);
                songs.add(song);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return songs;
    }

//    public ArrayList<Song> getAllSongsWith5Stars() {
//        ArrayList<Song> songs = new ArrayList<Song>();
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        String[] columns= {COLUMN_ID, COLUMN_TITLE, COLUMN_SINGERS, COLUMN_YEAR, COLUMN_STARS };
//        String condition = COLUMN_STARS + " Like ?";
//        String[] args = { "%" +  5 + "%"};
//        Cursor cursor = db.query(TABLE_SONGS, columns, condition, args,
//                null, null, null, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                int id = cursor.getInt(0);
//                String title = cursor.getString(1);
//                String singers = cursor.getString(2);
//                int year = cursor.getInt(3);
//                int stars = cursor.getInt(4);
//                Song song = new Song(id,title, singers, year, stars);
//                songs.add(song);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        return songs;
//    }
//
//    public ArrayList<Song> getAllSongsBasedOnYear( int yearFilter ) {
//        ArrayList<Song> songs = new ArrayList<Song>();
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        String[] columns= {COLUMN_ID, COLUMN_TITLE, COLUMN_SINGERS, COLUMN_YEAR, COLUMN_STARS };
//        String condition = COLUMN_YEAR + " Like ?";
//        String[] args = { "%" +  yearFilter + "%"};
//        Cursor cursor = db.query(TABLE_SONGS, columns, condition, args,
//                null, null, null, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                int id = cursor.getInt(0);
//                String title = cursor.getString(1);
//                String singers = cursor.getString(2);
//                int year = cursor.getInt(3);
//                int stars = cursor.getInt(4);
//                Song song = new Song(id,title, singers, year, stars);
//                songs.add(song);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        return songs;
//    }
//
//    public ArrayList<Song> getAllYears() {
//        ArrayList<Song> songs = new ArrayList<Song>();
//
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        String[] columns= { COLUMN_YEAR };
//        Cursor cursor = db.query(true,TABLE_SONGS, columns, null, null,
//                null, null, null, null);
//
//        if (cursor.moveToFirst()) {
//            do {
//                int year = cursor.getInt(0);
//                Song song = new Song(year);
//                songs.add(song);
//            } while (cursor.moveToNext());
//        }
//        cursor.close();
//        db.close();
//        return songs;
//    }

//    public int updateNote(Song data){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(COLUMN_TITLE, data.getTitle());
//        values.put(COLUMN_SINGERS, data.getSingers());
//        values.put(COLUMN_YEAR, data.getYear());
//        values.put(COLUMN_STARS, data.getStars());
//
//        String condition = COLUMN_ID + "= ?";
//        String[] args = {String.valueOf(data.getId())};
//        int result = db.update(TABLE_SONGS, values, condition, args);
//
//        db.close();
//        return result;
//    }
//
//    public int deleteNote(int id){
//        SQLiteDatabase db = this.getWritableDatabase();
//        String condition = COLUMN_ID + "= ?";
//        String[] args = {String.valueOf(id)};
//        int result = db.delete(TABLE_SONGS, condition, args);
//        db.close();
//        return result;
//    }

}