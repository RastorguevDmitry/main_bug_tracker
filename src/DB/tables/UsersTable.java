package DB.tables;

import DB.WorkTable;

import java.sql.SQLException;

public class UsersTable extends WorkTable {

    public UsersTable() throws SQLException {
        super("users");
    }

    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS users(" +
                "id INT AUTO_INCREMENT NOT NULL PRIMARY KEY," +
                "nameUser varchar(45) NOT NULL," +
                "UNIQUE INDEX id_UNIQUE (id )," +
                "UNIQUE INDEX nameUser_UNIQUE (nameUser ))");

    }




}
