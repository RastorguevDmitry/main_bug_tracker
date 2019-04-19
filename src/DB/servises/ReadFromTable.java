package DB.servises;

import DB.IssuesDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ReadFromTable {
    public enum TABLE {Project, User, Issue}

    public ReadFromTable() {
    }


    public void ReadFromTable(TABLE table) throws SQLException, ClassNotFoundException {

        IssuesDB issuesDB = new IssuesDB();
        Connection connection = issuesDB.getConnection();
        Statement statement = connection.createStatement();

        String stringForQuery = "";
        String stringNameColumn = "";
        switch (table) {
            case Project:
                stringForQuery = "projects";
                stringNameColumn = "nameProject";
                break;
            case User:
                stringForQuery = "users";
                stringNameColumn = "nameUser";
                break;
            case Issue:
                stringForQuery = "issues";
                stringNameColumn = "issueText";
                break;
        }

        String query = "select * from " + stringForQuery;
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            System.out.println("--> " + resultSet.getString(stringNameColumn));

        }
    }

    public static int getID(String table, String column, String name) throws SQLException, ClassNotFoundException {
        IssuesDB issuesDB = new IssuesDB();
        Connection connection = issuesDB.getConnection();
        Statement statement = connection.createStatement();
        String query = "select * from " + table + " where " + column + " = '" + name + "'";
        ResultSet resultSet = statement.executeQuery(query);
        if (resultSet.next()) return resultSet.getInt("id");
        return -1;
    }

    public static int dropAllTable() throws SQLException, ClassNotFoundException {
        IssuesDB issuesDB = new IssuesDB();
        Connection connection = issuesDB.getConnection();
        Statement statement = connection.createStatement();
        statement.execute("DROP TABLE users");
        statement.execute("DROP TABLE projects");
        statement.execute("DROP TABLE issues");
        return -1;
    }


    public static int printReport(String query) throws SQLException, ClassNotFoundException {
        int returnValue = 0;
        IssuesDB issuesDB = new IssuesDB();
        Connection connection = issuesDB.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            returnValue = 1;
            System.out.println("--> " + resultSet.getString("nameProject")
                    + " - " + resultSet.getString("nameUser") + " - " +
                    resultSet.getString("issueText"));
        }
        return returnValue;
    }

    public static int printReport(String inputProject, String inputUser) throws SQLException, ClassNotFoundException {
        String query = "select issues.issueText, users.nameUser, projects.nameProject  from issues " +
                "left join users on users.id=issues.iduser " +
                "left join projects on projects.id=issues.idproject " +
                "where users.nameUser = '" + inputUser + "' AND  projects.nameProject = '" + inputProject + "'";
        return printReport(query);
    }

    public static int printReport() throws SQLException, ClassNotFoundException {
        String query = "select issues.issueText, users.nameUser, projects.nameProject  from issues " +
                "left join users on users.id=issues.iduser " +
                "left join projects on projects.id=issues.idproject ";
        return printReport(query);
    }

}
