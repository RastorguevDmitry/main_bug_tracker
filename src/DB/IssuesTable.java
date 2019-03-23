package DB;

import java.sql.SQLException;

public class IssuesTable extends createTable {

    public IssuesTable() throws SQLException {
        super("issues");
    }

    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS issues(" +
                "idissue INT AUTO_INCREMENT NOT NULL PRIMARY KEY," +
                "issueText varchar(255) NOT NULL," +
                " iduser  INT NULL NOT NULL," +
                " idproject  INT NULL NOT NULL)", "Создана таблица " + tableName);
//
//                "ADD FOREIGN KEY (idproject) REFERENCES projects(idProject)" +
//                "ADD FOREIGN KEY (iduser) REFERENCES users(iduser)" +
//        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS issues(" +
//                "idissue INT AUTO_INCREMENT NOT NULL PRIMARY KEY," +
//                "issueText varchar(255) NOT NULL," +
//                " iduser  INT NULL NOT NULL," +
//                " idproject  INT NULL NOT NULL," +
//                " INDEX fk_project_idx (idproject ) ," +
//                " INDEX fk_user_idx (iduser ) ," +
//                " CONSTRAINT fk_project" +
//                " FOREIGN KEY (idproject)" +
//                " REFERENCES projects (idProject)" +
//                " ON DELETE CASCADE" +
//                " ON UPDATE NO ACTION" +
//                " CONSTRAINT fk_user" +
//                " FOREIGN KEY (iduser)" +
//                " REFERENCES users (iduser)" +
//                " ON DELETE CASCADE" +
//                " ON UPDATE NO ACTION)", "Создана таблица " + tableName);
        super.executeSqlStatement(" ALTER TABLE issues ADD FOREIGN KEY (idproject) REFERENCES projects(idProject)",
                "Cоздан внешний ключ issues.idproject -> projects.idProject");
        super.executeSqlStatement(" ALTER TABLE issues ADD FOREIGN KEY (iduser) REFERENCES users(iduser)",
                "Cоздан внешний ключ issues.iduser -> users.iduser");

    }

}
