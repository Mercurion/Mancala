package mercurion.mancala.database;

import android.content.Context;
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

    private static final String DATABASE_NAME = "matches.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE = "create table if not exist"
            + TABLE_MATCHES + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_WINNER
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
}
