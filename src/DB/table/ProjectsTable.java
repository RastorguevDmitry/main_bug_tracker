package DB.table;

import DB.WorkTable;

import java.sql.SQLException;

public class ProjectsTable extends WorkTable {

    public ProjectsTable() throws SQLException {
        super("projects");
    }

    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS projects(" +
                "id INT NOT NULL AUTO_INCREMENT NOT NULL PRIMARY KEY," +
                "nameProject varchar(45) NOT NULL," +
                "UNIQUE INDEX idprojects_UNIQUE (id) ,"+
                "UNIQUE INDEX nameProject_UNIQUE (nameProject) )");
    }


}
