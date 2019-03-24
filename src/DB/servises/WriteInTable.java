package DB.servises;

import DB.WorkTable;

import java.sql.SQLException;

public class WriteInTable extends WorkTable {

    public WriteInTable() throws SQLException {
        super("projects");
    }

    // запись в таблицу пользователей и проекты
    public void writeInTable(String table, String column, String name) throws SQLException {
        super.executeSqlStatement("INSERT INTO " + table + " (" + column + ") VALUES ('" + name + "')");
    }

    //записьв в таблицу Ошибок
    public void writeInTable(String table, int userID, int projectID, String issueText) throws SQLException {
        super.executeSqlStatement("INSERT INTO " + table +
                " (iduser, idproject, issueText)" +
                " VALUES ('" + userID + "' , '" + projectID + "', '" + issueText + "')");
    }

}
