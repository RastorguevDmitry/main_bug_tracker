package DB.table;

import DB.WorkTable;

import java.sql.SQLException;

public class IssuesTable extends WorkTable {

    public IssuesTable() throws SQLException {
        super("issues");
    }

    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS issues(" +
                "idissue INT AUTO_INCREMENT NOT NULL PRIMARY KEY," +
                "issueText varchar(255) NOT NULL," +
                " iduser  INT NULL NOT NULL," +
                " idproject  INT NULL NOT NULL)");

        super.executeSqlStatement(" ALTER TABLE issues ADD FOREIGN KEY (idproject) REFERENCES projects(id)");
        super.executeSqlStatement(" ALTER TABLE issues ADD FOREIGN KEY (iduser) REFERENCES users(id)");

    }

}
