package DB;

import java.sql.SQLException;

public class WriteInTable extends workTable {

    public WriteInTable() throws SQLException {
        super("projects");
    }

    public void writeInTable(String table, String column, String name) throws SQLException {
        super.executeSqlStatement("INSERT INTO " + table + " (" + column + ") VALUES ('" + name + "')");
    }

    public void writeInTable(String table, int userID, int projectID, String issueText) throws SQLException {
        super.executeSqlStatement("INSERT INTO " + table +
                " (iduser, idproject, issueText)" +
                " VALUES ('" + userID + "' , '" + projectID + "', '"+ issueText + "')");
    }

}
