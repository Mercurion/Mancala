package mercurion.mancala.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 21/05/2015.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String TABLE_MATCHES = "matches";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_WINNER = "winner";
    public static final String COLUMN_SCORE_P1 = "scoreP1";
    public static final String COLUMN_SCORE_P2 = "scoreP2";

    private static final String DATABASE_NAME = "matches.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table if not exist"
            + TABLE_MATCHES + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_SCORE_P1 + " integer , " + COLUMN_SCORE_P2 + " integer , "  + COLUMN_WINNER
            + " integer);";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MATCHES);
        onCreate(db);
    }

    // Adding new match
    public void addNewMatch(Matches match) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_SCORE_P1, match.getScoreP1());
        values.put(COLUMN_SCORE_P2, match.getScoreP2());
        values.put(COLUMN_WINNER, match.getWinner());
        // Inserting Row
        db.insert(TABLE_MATCHES, null, values);
        db.close(); // Closing database connection
    }

    // Getting single match
    public Matches getMatch(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_MATCHES, new String[] { COLUMN_ID,
                        COLUMN_SCORE_P1, COLUMN_WINNER }, COLUMN_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Matches match = new Matches(cursor.getInt(0),
                cursor.getInt(1), cursor.getInt(2), cursor.getInt(3));

        return match;
    }


    // Getting All Contacts
    public List<Matches> getAllMatches() {
        List<Matches> matchesList = new ArrayList<Matches>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MATCHES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Matches match = new Matches();
                match.setId(Integer.parseInt(cursor.getString(0)));
                match.setScoreP1(cursor.getInt(1));
                match.setScoreP2(cursor.getInt(2));
                match.setWinner(cursor.getInt(3));
                // Adding contact to list
                matchesList.add(match);
            } while (cursor.moveToNext());
        }

        // return match list
        return matchesList;
    }

    // Updating single match
    public int updateMatch(Matches match) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_SCORE_P1, match.getScoreP1());
        values.put(COLUMN_WINNER, match.getWinner());

        // updating row
        return db.update(TABLE_MATCHES, values, COLUMN_ID + " = ?",
                new String[] { String.valueOf(match.getId()) });
    }

    // Getting matches count
    public int getMatchesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_MATCHES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
}