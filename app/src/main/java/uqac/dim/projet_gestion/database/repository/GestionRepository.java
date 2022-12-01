package uqac.dim.projet_gestion.database.repository;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import uqac.dim.projet_gestion.database.UsersTable;
import java.util.ArrayList;
import java.util.List;

public class GestionRepository implements Repository {
    private SQLiteDatabase gestionDatabase;
    private Cursor cursor;



    /**
     * Constructor of the gestion repository.
     * @param gestionDatabase The writable database of the gestion application.
     */
    public GestionRepository(SQLiteDatabase sqLiteDatabase) {
        this.gestionDatabase = sqLiteDatabase;
        cursor = null;
    }
    
    
    /**
     * Find all user and order them by their last name.
     * @return A list of user ordered by their last name.
     * @throws RepositoryException
     */
    public List findAllbyLastName() throws RepositoryException {
        return makeUserList(UsersTable.SELECT_ALL_BY_LAST_NAME_SQL, null);
    }

    /**
     * Find all user and order them by employee number.
     * @return A list of user ordered by employee number.
     * @throws RepositoryException
     */
    public List findAllbyEmployeeNumber() throws RepositoryException {
        return makeUserList(UsersTable.SELECT_ALL_BY_EMPLOYEE_NUMBER_SQL, null);
    }

    /**
     * Create a list containing all users.
     * @return A list containing all users.
     * @throws RepositoryException
     */
    @Override
    public List findAll() throws RepositoryException {
        return makeUserList(UsersTable.SELECT_ALL_SQL, null);
    }

    /**
     * Create a list of user from the requested query.
     * @param query  the query requested.
     * @return return a list of the requested users.
     */
    private List<user> makeUserList(String query) {
        List<User> usersList = new ArrayList<>();
        gestionDatabase.beginTransaction();
        try {
            cursor = gestionDatabase.rawQuery(query, new String[]{});

            while (cursor.moveToNext()) {
                user.add(buildUser(cursor));
            }
            gestionDatabase.endTransaction();
            return usersList;

        } finally {
            if (cursor != null)
                cursor.close();
        }
    }

    private user buildUser(Cursor cursor) {
        int userId = cursor.getInt(DatabaseOrder.ID.ordinal());
        return new User(
                cursor.getInt(DatabaseOrder.ID.ordinal()),
                cursor.getInt(DatabaseOrder.EMPLOYEE_NUMBER.ordinal()),
                cursor.getString(DatabaseOrder.FIRST_NAME.ordinal()),
                cursor.getString(DatabaseOrder.LAST_NAME.ordinal()),
                cursor.getString(DatabaseOrder.EMAIL.ordinal()),
                cursor.getString(DatabaseOrder.PASSWORD.ordinal()),
                cursor.getReal(DatabaseOrder.MAX_HOURS.ordinaL()),
                cursor.getString(DatabaseOrder.WOKRSTATION.ordinal()),
                cursor.getString(DatabaseOrder.QUALIFICATION.ordinal()),
                cursor.getInt(DatabaseOrder.ACCESS.ordinal()),
        );
    }


    /**
     * Enum containing the order of the columns in a single row of the table user.
     */
    public enum DatabaseOrder {
        ID, EMPLOYEE_NUMBER, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, MAX_HOURS, WOKRSTATION, QUALIFICATION, ACCESS
    }
}
