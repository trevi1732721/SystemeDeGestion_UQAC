package uqac.dim.projet_gestion.database;

public class UsersTable {
    public static final String CREATE_USERS_TABLE_SQL =
            "CREATE TABLE IF NOT EXISTS `users`  (" +
                    "`user_id`	INTEGER NOT NULL UNIQUE," +
                    "`user_first_name`	TEXT NOT NULL," +
                    "`user_last_name`	TEXT NOT NULL," +
                    "`user_email`	TEXT NOT NULL," +
                    "`user_password`	TEXT NOT NULL," +
                    "`user_max_hours`	REAL," +
                    "`user_workstation`	TEXT," +
                    "`user_qualification`	TEXT," +
                    "`user_access`	INTEGER NOT NULL," +
                    "PRIMARY KEY(`user_id` AUTOINCREMENT))";

    public static final String DROP_USERS_TABLE_SQL = "DROP TABLE IF EXISTS `users`;";

    public static final String SELECT_ALL_SQL = "SELECT user_id, user_first_name, user_last_name, user_email, user_password, user_max_hours, user_workstation, user_qualification, user_access FROM users";

    public static final String SELECT_ALL_BY_ID = "SELECT user_id, user_first_name, user_last_name, user_email, user_password, user_max_hours, user_workstation, user_qualification, user_access" +
            " FROM users ORDER BY user_id";

    public static final String SELECT_ALL_BY_LAST_NAME_SQL = "SELECT user_id, user_first_name, user_last_name, user_email, user_password, user_max_hours, user_workstation, user_qualification, user_access" +
            "FROM users" +
            "ORDER BY user_last_name";


    //public static final String UPDATE_USER_HOURS = "UPDATE `users` SET user_max_hours=? WHERE user_employee_number=?";

    public static final String INSERT_USER_INTO_DATABASE_SQL = " INSERT INTO `USERS` (`user_id`,`user_first_name`,`user_last_name`,`user_email`,`user_password`,`user_max_hours`,`user_workstation`,`user_qualification`,`user_access`)";

    private UsersTable() {
        //Private constructor to prevent instantiation
    }



    public static final String FILL_USER_EXEMPLE_SQL = " INSERT INTO `USERS` (`user_id`,`user_first_name`,`user_last_name`,`user_email`,`user_password`,`user_max_hours`,`user_workstation`,`user_qualification`,`user_access`)" +
            "VALUES (1,'Mike','Tyson','miketyson@onepunchman.com','KnockOut',7,'Boxer','KnockOut Master',1)"+
            "VALUES (2,'Mik2e','Tys3on','miketys2on@onepunchman.com','Knoc2kOut',72,'B2oxer','Kn2ockOut Mast2er',2)"+
            "VALUES (3,'Mi3ke','Ty3son','miket3yson@onepunchman.com','KnockO3ut',73,'B3oxer','Knoc3kOut M3aster',3)";


}
