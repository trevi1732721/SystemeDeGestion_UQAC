package uqac.dim.projet_gestion.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class GestionDatabaseConnectionFactory extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 7;
    private static String DATABASE_FILE_NAME = "Gestion";

    public GestionDatabaseConnectionFactory(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase gestionDb) {
        gestionDb.execSQL(UsersTable.CREATE_USERS_TABLE_SQL);
        gestionDb.execSQL(UsersTable.FILL_USER_EXEMPLE_SQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase gestionDb, int oldVersion, int newVersion) {
        gestionDb.execSQL(UsersTable.DROP_USERS_TABLE_SQL);
        onCreate(gestionDb);
    }
}
