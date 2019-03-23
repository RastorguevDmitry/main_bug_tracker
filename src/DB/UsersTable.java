package DB;

import java.sql.SQLException;

public class UsersTable extends createTable {

    public UsersTable() throws SQLException {
        super("users");
    }

    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS users(" +
                "iduser INT AUTO_INCREMENT NOT NULL PRIMARY KEY," +
                "nameUser varchar(45) NOT NULL," +
                "UNIQUE INDEX iduser_UNIQUE (iduser )," +
                "UNIQUE INDEX nameUser_UNIQUE (nameUser ))", "Создана таблица " + tableName);

    }




}
