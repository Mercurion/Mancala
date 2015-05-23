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
public class DBManager extends SQLiteOpenHelper {

    public static final String TABLE_MATCHES = "matches";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_WINNER = "winner";
    public static final String COLUMN_SCORE = "score";

    private static final String DATABASE_NAME = "matches.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table if not exist"
            + TABLE_MATCHES + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_SCORE + " integer primary key autoincrement, "  + COLUMN_WINNER
            + " text not null);";

    public DBManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBManager.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MATCHES);
        onCreate(db);
    }

    // Adding new match
    void addMAtch(Matches match) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_WINNER, match.getWinner()); // Contact Name
        values.put(COLUMN_SCORE, match.getBest_score()); // Contact Phone

        // Inserting Row
        db.insert(TABLE_MATCHES, null, values);
        db.close(); // Closing database connection
    }

    // Getting single match
    Matches getMatch(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_MATCHES, new String[] { COLUMN_ID,
                        COLUMN_SCORE, COLUMN_WINNER }, COLUMN_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Matches match = new Matches(Integer.parseInt(cursor.getString(0)),
                cursor.getString(2), cursor.getInt(1));
        // return match
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
                match.setBest_score(cursor.getInt(1));
                match.setWinner(cursor.getString(2));
                // Adding contact to list
                matchesList.add(match);
            } while (cursor.moveToNext());
        }

        // return match list
        return matchesList;
    }


}
