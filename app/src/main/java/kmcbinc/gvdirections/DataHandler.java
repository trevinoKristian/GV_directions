package kmcbinc.gvdirections;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 2/18/2016.
 */
public class DataHandler extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "buildings";
    private static final String TABLE_BUILDINGS = "building_table";
    private static final String KEY_NAME = "name",
    KEY_DESCRIPTION = "description",
    KEY_ABBREVIATION = "abbreviation";

    public DataHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE" + TABLE_BUILDINGS + "(" + KEY_NAME + "STRING PRIMARY KEY, " +
                KEY_ABBREVIATION + "TEXT, " + KEY_DESCRIPTION + "TEXT");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BUILDINGS);
        onCreate(db);
    }

    public void createBuilding(building build){
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, build.getName());
        values.put(KEY_ABBREVIATION, build.getAbbreviation());
        values.put(KEY_DESCRIPTION, build.getDescription());

        db.insert(TABLE_BUILDINGS, null, values);
    }

    public building getBuilding(String name){
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_BUILDINGS, new String[] {KEY_NAME, KEY_ABBREVIATION, KEY_DESCRIPTION}, KEY_NAME + "=?", new String[]{name}, null, null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        building build = new building(cursor.getString(0), cursor.getString(1), cursor.getString(2));

        return build;
    }


}
