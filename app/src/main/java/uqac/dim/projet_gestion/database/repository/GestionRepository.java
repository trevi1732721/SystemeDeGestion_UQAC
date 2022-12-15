package uqac.dim.projet_gestion.database.repository;

import uqac.dim.projet_gestion.Model.User;
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
     * @param sqLiteDatabase The writable database of the gestion application.
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
        return makeUserList(UsersTable.SELECT_ALL_BY_LAST_NAME_SQL);
    }

    /**
     * Find all user and order them by employee number.
     * @return A list of user ordered by employee number.
     * @throws RepositoryException
     */
    public List findAllbyUserId() throws RepositoryException {
        return makeUserList(UsersTable.SELECT_ALL_BY_ID);
    }

    /**
     * Create a list containing all users.
     * @return A list containing all users.
     * @throws RepositoryException
     */
    @Override
    public List findAll() throws RepositoryException {
        return makeUserList(UsersTable.SELECT_ALL_SQL);
    }

    /**
     * Create a list of user from the requested query.
     * @param query  the query requested.
     * @return return a list of the requested users.
     */
    private List<User> makeUserList(String query) {
        List<User> usersList = new ArrayList<>();
        gestionDatabase.beginTransaction();
        try {
            cursor = gestionDatabase.rawQuery(query, new String[]{});

            while (cursor.moveToNext()) {
                usersList.add(buildUser(cursor));
            }
            gestionDatabase.endTransaction();
            return usersList;

        } finally {
            if (cursor != null)
                cursor.close();
        }
    }

    private User buildUser(Cursor cursor) {
       // int userId = cursor.getInt(DatabaseOrder.ID.ordinal());
        return new User(
                cursor.getInt(DatabaseOrder.ID.ordinal()),
                cursor.getString(DatabaseOrder.FIRST_NAME.ordinal()),
                cursor.getString(DatabaseOrder.LAST_NAME.ordinal()),
                cursor.getString(DatabaseOrder.EMAIL.ordinal()),
                cursor.getInt(DatabaseOrder.MAX_HOURS.ordinal()),
                cursor.getString(DatabaseOrder.WORKSTATION.ordinal()),
                cursor.getString(DatabaseOrder.QUALIFICATION.ordinal()),
                cursor.getInt(DatabaseOrder.ACCESS.ordinal())
                //tasksRepository.getAllTask(userId)
        );
    }


    /**
     * Enum containing the order of the columns in a single row of the table user.
     */
    public enum DatabaseOrder {
        ID, FIRST_NAME, LAST_NAME, EMAIL, PASSWORD, MAX_HOURS, WORKSTATION, QUALIFICATION, ACCESS
    }
}
