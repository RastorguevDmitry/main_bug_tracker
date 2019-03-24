package DB;

import java.io.File;
import java.sql.*;

import org.h2.tools.DeleteDbFiles;

public class IssuesDB {

    public static String DB_DIR;
    public static final String DB_FILE = "bug_tracker";
    public static String DB_URL;
    public static final String DB_Driver = "org.h2.Driver";

    // Таблицы СУБД
    UsersTable usersTable;
    ProjectsTable projectsTable;
    IssuesTable issuesTable;


    public static Connection getConnection() throws SQLException {
        String dir = new File("").getAbsolutePath();
        DB_DIR = dir + "/main_bug_tracker/db";
        DB_URL = "jdbc:h2:/" + DB_DIR + "/" + DB_FILE;
        return DriverManager.getConnection(DB_URL);
    }

    public IssuesDB(boolean renew) throws SQLException, ClassNotFoundException {
        if (renew)
            DeleteDbFiles.execute(DB_DIR, DB_FILE, false);
        Class.forName(DB_Driver);
        // Инициализируем таблицы
        usersTable = new UsersTable();
        projectsTable = new ProjectsTable();
        issuesTable = new IssuesTable();
    }

    public IssuesDB() throws SQLException, ClassNotFoundException {
        Class.forName(DB_Driver);
        // Инициализируем таблицы
        usersTable = new UsersTable();
        projectsTable = new ProjectsTable();
        issuesTable = new IssuesTable();
    }

    public void createTables() throws SQLException {
        usersTable.createTable();
        projectsTable.createTable();
        issuesTable.createTable();
    }


}
