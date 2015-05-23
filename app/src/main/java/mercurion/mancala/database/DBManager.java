package mercurion.mancala.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

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
                cursor.getString(1), cursor.getInt(2));
        // return match
        return match;
    }


}
