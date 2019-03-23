package DB;

import java.sql.SQLException;

public class ProjectsTable extends createTable{

    public ProjectsTable() throws SQLException {
        super("projects");
    }

    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS projects(" +
                "idproject INT NOT NULL AUTO_INCREMENT NOT NULL PRIMARY KEY," +
                "nameProject varchar(45) NOT NULL," +
                "UNIQUE INDEX idproject_UNIQUE (idproject) ,"+
                "UNIQUE INDEX nameProject_UNIQUE (nameProject) )", "Создана таблица " + tableName);
    }

}
